# Dokumentacja

### Cel

Celem budowy aplikacji było przede wszystkim zaznajomienie się z podstawami frameworka SpringBoot oraz obsługa danych poprzez API dostarczanych w różnych formatach.
Obecnie istnieje kilka dostępnych serwisów w podobnej tematyce. Dlatego też przy projektowaniu starano się zwrócić uwagę, aby niepowielać istniejących rozwiązań, lecz zaproponować trochę inne podejście.
### Wykorzystane API, technologie oraz biblioteki

* https://dane.gov.pl/en/dataset/762,ruch-statkow-w-portach-polskich
* https://leafletjs.com/
* Thymeleaf
* Hibernate (SpringData)
* PostgreSQL
* Docker
* SpingBoot Web
* DataTables.js

### Rozwój
Aplikację starano się zaprojektować w taki sposób, aby dokonać w przyszłości jej rozbudowy.
Pomysły:
* wyszukiwarka statków
* dodawanie do "floty" ulubionych statków
* wykorzystanie API z dokładną pozycją statków (niestety na chwilę obecną brak bezpłatnych API z lokalizacją. W aplikacji wykorzystano losowanie punktów w zadanym obszarze)
* śledzenie historii (utworzenie serwisu zapisującego do bazy danych historycznych)
* zdjęcie statku
* podgląd kamery w porcie
* wyświetlanie liczby statków w danym porcie
* oznaczenie rodzajów statków za pomocą innej ikony
* dodanie lokalizacji latarni morskich

### Uruchomienie aplikacji
należy przejść do katalogu z projektem i wykonać polecenie:

docker-compose up --force-recreate

w przypadku problemów z uruchomieniem należy utworzyć bazę danych ręcznie:

- uruchomić dockera
- przejść do konsoli kontenera bazy danych
- wykonać polecenia:
su - postgres
a następnie
create database marinas;

### Demonstracja

Demonstracja funkcjonalności aplikacji znajduje się pod poniższym linkiem:
https://youtu.be/Aoau84tHRl8
