package pl.koty.monitorowaniejednostekmorskich21.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrackService {
    RestTemplate restTemplate = new RestTemplate();


    public List<Point> getTracks() {


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjBCM0I1NEUyRkQ5OUZCQkY5NzVERDMxNDBDREQ4OEI1QzA5RkFDRjMiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJDenRVNHYyWi03LVhYZE1VRE4ySXRjQ2ZyUE0ifQ.eyJuYmYiOjE2Mzg3Nzg5NTAsImV4cCI6MTYzODc4MjU1MCwiaXNzIjoiaHR0cHM6Ly9pZC5iYXJlbnRzd2F0Y2gubm8iLCJhdWQiOiJhcGkiLCJjbGllbnRfaWQiOiJnbm9iaXNrYUBnbWFpbC5jb206cGV0ZXJuZXJkMjAwNCIsInNjb3BlIjpbImFwaSJdfQ.QumqUhkhSdtSrZDIQyIS9IA5llTk025uY12phAPGvf9zN0k83_qxe-Y-NcuaFiU9Y-WZo5iNsqVDqciK3cZdIrVnRrnctlHS8CX-i2VqrixuzVxDUxj9MaClBRjKTvLqAdEE8ZCyUZXH3qDkcwt62ZB53CHNxstrjVMXkxThKdQgOfAEZ4oHS8TYiO8ev3vPbZ4BNeKICw4uuY6QMVzN_HUJkY88FHAVq_L3CY6jKHV9URWK6qqobN5ObY86Pe01LOaRQJBbHlj701mUvBqsVky1_GOxEcCBekuxTorCqyPZggAjd54wLFzif2rpETuq07W7-zgDRbufxlvsaRh3chuIdKV7qphLg3TkkvVZ15BkfZ2cz40rB8sjCMsfOxkxpC0iqvEPc7WVbKtM12PY647CEq3-1R5L-Ew7zA7pjbDap9Ty_iqKg-ljgwJUYxaVBDZFAhD2OujeCrFvxl2WwjiFUjjSmrOPh7-hvBoRHlVhmAeBqLLiyQhNLMwKoO1EFerlPakntXs0GnRnQMFk351g6_2Q5ey8cza-QzcoIs-CYs2B70pz9MQqhoLOa56mTcZmWc-AofoqwxF2n2A9ExSt2HkT1MuyjiHd_id6oMyX-07Z21ZILCC8Q5x9z1dCiHqEKWzPC9vyXFjbKM7l_02UTRX1LEDQLPhxIGimDK8");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<Track[]> exchange = restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET,
                httpEntity,
                Track[].class);


        List<Point> collect = Stream.of(exchange.getBody()).map(

                       track -> new Point(
                                track.getGeometry().getCoordinates().get(0),
                                track.getGeometry().getCoordinates().get(1),
                                track.getName(),
                                getDestination(track.getDestination(), track.getGeometry().getCoordinates()).getLongitude(),
                                getDestination(track.getDestination(), track.getGeometry().getCoordinates()).getLatitude()
                       )

        ).collect(Collectors.toList());
        return collect;
    }

    public Datum getDestination(String destinationName, List<Double> coordinates) {
        try {

            String url = "http://api.positionstack.com/v1/forward?access_key=f32fc630d7ead0f43babcded567372d9&query=" + destinationName;
            JsonNode data = restTemplate.getForObject(url, JsonNode.class).get("data").get(0);
             double latitude = data.get("latitude").asDouble();
             double longitude = data.get("longitude").asDouble();

             return new Datum(latitude, longitude);

        } catch (Exception ex) {

            return new Datum(46.796718, 2.426753);
        }
    }
}