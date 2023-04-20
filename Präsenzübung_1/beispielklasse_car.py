class Fahrzeug:
    def __init__(self, reifen, sitze):
        self.reifen = reifen
        self.sitze = sitze
        self.geschwindigkeit = 0

    def __str__(self):
        return f'Ein Fahrzeug mit {self.sitze} Sitzen'

    def beschleunigen(self, wert):
        self.geschwindigkeit += wert

    
pkw = Fahrzeug(4, 5)
print(pkw)

print(pkw.geschwindigkeit)
pkw.beschleunigen(30)
print(pkw.geschwindigkeit)