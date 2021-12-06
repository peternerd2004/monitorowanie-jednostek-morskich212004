# monitorowanie-jednostek-morskich
> System ma za zadanie lokalizowanie i śledzenie jednostek morskich
> Przydatne linki do uruchomienia programu, dzkieki temu będziesz mógł pobrać darmowe api: https://www.barentswatch.no/en/about/open-data-via-barentswatch/
https://www.barentswatch.no/minside/
-Zobacz na inne free API dla AIS:

>https://opendata.stackexchange.com/questions/15329/free-source-of-ais-data-api

## Spis treści
* [Informacje ogólne](#informacje-ogólne)
* [Wykorzystane technologie](#wykorzystane technologie)
* [Funkcje](#funkcje)
* [Konfiguracja](#konfiguracja)
* [Wykorzystanie](#wykorzystanie)
* [Stan projektu](#status-projektu)
* [Miejsce na ulepszenia](#miejsce-do-ulepszeń)
* [Podziękowania](#podziękowania)
* [Kontakt](#kontakt)



## Informacje ogólne
Celem projektu jest zoptymalizowanie lokalizacji jednostek morskich.Bespieczna nawigacja itd
Podjąłem się tego projektu uprościć np.przewozu regionalne.


## Użyte technologie
- docker
- najnowsza wersja spring boot


## Cechy
Lista gotowych funkcji tutaj:
- wystarczy najechać myszką wybrany obiekt, żeby ustalić jego docelowość




## Uruchamianie aplikacji w środowisku inetllij IDEA( w przykładzie)
-Zbuduj i uruchom aplikację

Kliknij Dostosuj i wybierz inny motyw kolorystyczny lub zaznacz pole wyboru Synchronizuj z systemem operacyjnym,ustawienia ułatwień dostępumain()przycisk Uruchom Usuń

Kliknij przycisk Uruchom Usuńw rynnę i wybierz Uruchom 'HelloWorld.main()' w wyskakującym okienku. IDE zaczyna kompilować twój kod.

Po zakończeniu kompilacji na dole ekranu otworzy się okno narzędzia Uruchom .

Pierwsza linia pokazuje polecenie, którego IntelliJ IDEA użył do uruchomienia skompilowanej klasy. Druga linia pokazuje wyjście programu: Hello, World!. A ostatnia linia pokazuje kod wyjścia 0, który wskazuje, że zakończyło się pomyślnie.

Jeśli kod nie jest poprawny, a środowisko IDE nie może go skompilować, w oknie narzędzia Uruchom zostanie wyświetlony odpowiedni kod zakończenia.

Gdy klikniesz Uruchom , IntelliJ IDEA tworzy specjalną konfigurację uruchamiania, która wykonuje szereg działań. Najpierw buduje twoją aplikację. Na tym etapie javac kompiluje twój kod źródłowy do kodu bajtowego JVM.

Po zakończeniu kompilacji javac umieszcza skompilowany kod bajtowy w katalogu out , który jest podświetlony na żółto w oknie narzędzia Project .

Następnie JVM uruchamia kod bajtowy.

Automatycznie tworzone konfiguracje przebiegu są tymczasowe, ale można je modyfikować i zapisywać .

Jeśli chcesz ponownie otworzyć okno narzędzia Uruchom , naciśnij Alt+4.

IntelliJ IDEA automatycznie analizuje plik, który jest aktualnie otwarty w edytorze i wyszukuje różnego rodzaju problemy: od błędów składniowych po literówki. W Kontrole widżetu u góry w prawym rogu edytora pozwala szybko zobaczyć wszystkich wykrytych problemów i spojrzeć na każdego problemu w szczegółach. Aby uzyskać więcej informacji, zobacz Bieżący plik .

Spakuj aplikację w JAR﻿

Utwórz konfigurację artefaktu dla JAR﻿
Z menu głównego wybierz Plik | Struktura projektu Ctrl+Alt+Shift+S i kliknij opcję Artefakty .

Kliknij przycisk Dodaj, wskaż JAR i wybierz Z modułów z zależnościami .

Po prawej stronie pola Klasa główna kliknij przycisk Przeglądaji wybierz HelloWorld (com.example.helloworld) w otwartym oknie dialogowym.

IntelliJ IDEA tworzy konfigurację artefaktu i pokazuje jego ustawienia w prawej części okna dialogowego Struktura projektu .

Zastosuj zmiany i zamknij okno.

Zbuduj artefakt JAR﻿
Z menu głównego wybierz Buduj | Artefakty kompilacji .

Wskaż HelloWorld:jar i wybierz Build .

Budowanie artefaktu
Jeśli teraz spojrzysz na folder out/artifacts , znajdziesz tam swój plik JAR.

Powstaje artefakt JAR
Uruchom spakowaną aplikację﻿

Użyj funkcji Znajdź akcję, Ctrl+Shift+A aby wyszukać akcje i ustawienia w całym środowisku IDE.

Utwórz konfigurację uruchamiania dla spakowanej aplikacji﻿
Aby uruchomić aplikację Java spakowaną w JAR, IntelliJ IDEA umożliwia utworzenie dedykowanej konfiguracji uruchamiania.

Naciśnij Ctrl+Shift+A, znajdź i uruchom akcję Edytuj konfiguracje .

W oknie dialogowym Uruchom/debuguj konfiguracje kliknij przycisk Dodaji wybierz Aplikacja JAR .

Nazwij nową konfigurację: HelloWorldJar.

https://resources.jetbrains.com/help/img/idea/2021.3/run-debug.png
Gif
W polu Ścieżka do JAR kliknij przycisk Przeglądaji określ ścieżkę do pliku JAR na komputerze.

Przewiń w dół okno i pod Przed uruchomieniem kliknij przycisk Dodaj, wybierz Build Artefakty | HelloWorld:jar w otwartym oknie dialogowym.

Oznacza to, że plik HelloWorld.jar jest budowany automatycznie za każdym razem, gdy wykonujesz tę konfigurację uruchamiania.

https://resources.jetbrains.com/help/img/idea/2021.3/run-config-ending.png
Gif
Konfiguracje uruchamiania pozwalają określić, w jaki sposób chcesz uruchomić aplikację, z jakimi argumentami i opcjami. Możesz mieć wiele konfiguracji uruchamiania dla tej samej aplikacji, każda z własnymi ustawieniami.

Wykonaj konfigurację uruchomienia﻿
Na pasku narzędzi wybierz HelloWorldJarkonfigurację i kliknij przycisk Uruchompo prawej stronie selektora konfiguracji uruchamiania. Shift+F10Możesz też nacisnąć, jeśli wolisz skróty.

Tak jak poprzednio, otworzy się okno Uruchom narzędzie i wyświetli dane wyjściowe aplikacji.

https://resources.jetbrains.com/help/img/idea/2021.3/jt-run-jar.png
Gif
Proces zakończył się pomyślnie, co oznacza, że ​​aplikacja została poprawnie spakowana'
 ## Podziękowania
 Specjalne podziękowania dla:
 >https://ctm.gdynia.pl/
 
 ##kontakt:
 gnobiska@gmail.com
 

