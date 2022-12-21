# Checkers
Project for Technology of Programming class at University of Scienece and Technology in Wroclaw, winter semester 2022/2023

Rodzaje warcab:
- warcaby dwuliniowe 8 x 8, tak, tak, dowolnego, nie, czarne
- warcaby polskie 10 x 10, tak, tak, najelpszego, tak, czarne
- warcaby klasyczne 8 x 8, tak, tak, najlepszego, tak, czarne *PODSTAWA*

Widok:
- Gui w Swingu, szachownica i pionki
- Po kliknięci swojego pionka pionek przechodzi w stan aktywny
- Podświetlane są pola na które pionek może się poruszyć
- poruszamy się tyko po czarnych polach
- 

Model:
- tworzy [][] array z 0, 1, i 2 na poczatku gry 0 - puste pole 1- bialy 2- czarny
- kazdy pionek pobiera informacje o polach 
- checker board ma w konstruktorze array[][] na podstawie ktorego buduje plansze
