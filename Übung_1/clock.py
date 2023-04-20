
class Clock:
    '''Einfache 24-Stunden-Uhr ohne Sekunden'''

    def __init__(self,hours,minutes):
        '''Initialisiere mit angegebenen Minuten und Sekunden. Bei ungültiger Startzeit wird die Uhr auf 00:00 gesetzt.'''
       
        if self.check_for_valid_time(hours,minutes):
            self.hours = hours
            self.minutes = minutes
        else:
            print('Unngültige Startzeit. Uhrzeit wird auf 00:00 Uhr gesetzt.')
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
            print('Unngültige Uhrzeit. Uhrzeit wird auf 00:00 Uhr gesetzt.')
            self.hours = 0
            self.minutes = 0

    def add_minutes(self,minutes):
        '''Fügt die angegebene Anzahl an Minuten zur aktuellen Zeit hinzu. Negative Eingaben sind möglich. Das Ergebnis muss wieder eine gültige Uhrzeit sein.'''
        if (0 <= self.minutes + minutes) and (self.minutes + minutes < 60):
            self.minutes += minutes
        # Um wie viele Stunden ist neue Minutenzeit verschoben??? Muss doch auch schöner gehen...
        elif 0 < minutes:
            # Berechne um wie viele Stunden und Minuten ich verschieben muss
            dHH = minutes // 60 # Ganzzahliges Teilen für Stunden, die addiert werden müssen
            dmm = minutes % 60  # Modulo für Minuten, die addiert werden müssen
            # hier addieren, if-Abfragen ob Werte für Stunde und Minute noch gültig sind.
            self.hours += dHH
            self.minutes += dmm
            if self.check_for_valid_time(self.hours+dHH,self.minutes+dmm):
                pass
            elif 24 <= self.hours:
                pass  # Hier ausrechnen, wie ich anpassen muss...

    def __str__(self):
        '''Gebe Zeit als string im Format HH:mm zurück. Bei Stunden und Minuten kleiner 10 werden führende Nullen ergänzt.
        Ereiche dies, indem auf String-Länge getestet wird.'''
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

# divmod???


c = Clock(10,30)
c.set_time(15,45)
print(c)
c.add_minutes(10)
print(c)
c.add_minutes(-6)
print(c)
print('Gerade Stunde?: ',c.is_even_hour())


# c2 = Clock(66,4)
# c2.set_time(4,4)
# print(c2)