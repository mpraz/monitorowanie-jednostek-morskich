# Dokumentacja

### Opis aplikacji

Aplikacja prezentuje aktualnie znajdujące się statki w Porcie Gdynia, Porcie Gdańsk Port Północny i Gdańsk Nowy Port, Porcie Świnoujście, Porcie Police, Porcie Szczecin.
Po kliknięciu na statek możemy zapoznać się z podstawowymi informacjami, np. skąd statek przypłynął, kiedy wpłynął do portu, a także z jakiego pochodzi kraju.
Dodatkowo po kliknięciu w szczegóły danego portu, możemy w formie tabeli zapoznać się z aktualnymi statkami w porcie. Bardzo łatwo też można znaleźć statki, które dokują w porcie już kilka lat!

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

### Przygotowanie środowiska
Poniższe polecenia dot. uruchomienia aplikacji w środowisku Ubuntu 18

1. GIT - czyli klonujemy kod:
Przechodzimy od katalogu, ktory bedzie zawieral repozytorium
```
cd ~/Project
```

Tworzymy nowy katalog do przechowywania repozytorium
```
mkdir -p ~/Project
```
Aby sklonować repozytorium, uruchamiamy ponizsze polecenie:
```
git clone https://github.com/mpraz/monitorowanie-jednostek-morskich.git monitorowanie-jednostek-morskich
```

2. Maven - aby wygenerować jar-a
Instalacja Maven'a:
```
sudo apt update
sudo apt install maven
mvn -version
```
Komplilacja:
```
mvn clean compile package -DskipTests
```
3. Docker - aby uruchomić środowisko

Instalacja Dockera:
```
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh
```

Instalacja Docker-Compose:
```
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
docker-compose --version
```
Start dockera:
```
sudo dockerd --iptables=false &
docker-compose up --force-recreate
```
Dla diagnostyki:
```
sudo dockerd -D
```

### Uruchomienie aplikacji
należy przejść do katalogu z projektem i wykonać polecenie:

```
docker-compose up --force-recreate
```
w przypadku problemów z uruchomieniem należy utworzyć bazę danych ręcznie:

- uruchomić Dockera 
- przejść do konsoli kontenera bazy danych (docker-compose exec server bash)
- wykonać polecenia:
su - postgres
a następnie
create database marinas;

Aplikacja dostępna pod adresem:
http://localhost:8000

### Demonstracja

Demonstracja funkcjonalności aplikacji znajduje się pod poniższym linkiem:
https://youtu.be/Aoau84tHRl8
