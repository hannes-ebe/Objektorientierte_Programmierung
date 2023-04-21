
class Clock:
    '''Einfache 24-Stunden-Uhr ohne Sekunden'''

    def __init__(self,hours,minutes):
        '''Initialisiere mit angegebenen Minuten und Sekunden. Bei ungültiger Startzeit wird die Uhr auf 00:00 gesetzt.'''
       
        if self.check_for_valid_time(hours,minutes):
            self.hours = hours
            self.minutes = minutes
        else:
            # print('Unngültige Startzeit. Uhrzeit wird auf 00:00 Uhr gesetzt.')
            self.hours = 0
            self.minutes = 0

    def check_for_valid_time(self,hours,minutes):
        'Überprüft, ob übergebene Zeit gültig ist. Als Parameter werden nur Integer von 0 bis 23 bzw. 0 bis 59 akzeptiert.'
        return isinstance(hours,int) and isinstance(minutes,int) and (0<=hours) and (hours<24) and (0<=minutes) and (minutes<60)
    
    def set_time(self,hours,minutes):
        '''Stellt die Uhr auf die angegebenen Parameter. Bei ungültiger Zeit wird die Uhr auf 00:00 gesetzt.'''
        if self.check_for_valid_time(hours,minutes):
            self.hours = hours
            self.minutes = minutes
        else:
            # print('Unngültige Uhrzeit. Uhrzeit wird auf 00:00 Uhr gesetzt.')
            self.hours = 0
            self.minutes = 0

    def add_minutes(self,minutes):
        '''Fügt die angegebene Anzahl an Minuten zur aktuellen Zeit hinzu. Negative Eingaben sind möglich. Das Ergebnis muss wieder eine gültige Uhrzeit sein.'''
        t = self.hours * 60 + self.minutes + minutes    # Rechne aktuelle Zeit in Minuten seit 00:00 Uhr um und addiere die entsprechenden Minuten.
        h = t // 60                                     # Ganzzahliges Teilen für Stunden
        m = t % 60                                      # Modulo (Rest) für Minuten
        h = h % 24                                      # Modulo (Rest) für Stunden auf der Uhr (alle 24h wiederholt sich Uhrzeit)

        self.minutes = m
        self.hours = h

    def __str__(self):
        '''Gebe Zeit als string im Format HH:mm zurück. Bei Stunden und Minuten kleiner 10 werden führende Nullen ergänzt.
        Erreiche dies, indem auf String-Länge getestet wird.'''
        HH = str(self.hours)
        mm = str(self.minutes)
        if len(HH) < 2:
            HH = '0' + HH
        if len(mm) < 2:
            mm = '0' + mm
        return HH + ':' + mm

    def is_even_hour(self):
        '''Überprüft, ob die Stunde gerade ist und gibt boolschen Wert zurück.'''
        if self.hours % 2 == 0:
            return True
        else:
            return False


c = Clock(10,30)
print(c)
c.set_time(15,45)
print(c)
c.add_minutes(10)
print(c)
c.add_minutes(-6)
print(c)
c.add_minutes(-960)
print(c)
c.add_minutes(+63)
print(c)
c.set_time(30,8)
c.set_time(8,70)
c.set_time(99,99)
print('Gerade Stunde?: ',c.is_even_hour())


c2 = Clock(66,4)
print(c2)
c2.set_time(4,4)
print(c2)