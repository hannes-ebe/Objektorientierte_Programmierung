import datetime as dt
import time

class Timer:
    def  __init__(self):
        self.start_time = None
        self.elapsed_time = dt.timedelta()     # leeres Objekt der Klasse timedelta

    def start(self):
        if self.start_time != None:
            print('Timer läuft schon!')
        else:
            self.start_time = dt.datetime.now()

    def stop(self):
        if self.start_time == None:
            print('Timer läuft noch nicht!')
        else:
            self.elapsed_time = dt.datetime.now() - self.start_time
            self.start_time = None

    def reset(self):
        self.start_time = None
        self.elapsed_time = dt.timedelta()

    def display(self):
        print(self.elapsed())

    def elapsed(self):
        return self.elapsed_time


timer = Timer()
timer.start()
timer.start()
timer.display()

time.sleep(10)

timer.stop()
timer.display()