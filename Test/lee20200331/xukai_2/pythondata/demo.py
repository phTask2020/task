def start_apple():
    print('Start do...')


class apple:

    def __init__(self):
        self.apple = 0
        self.water = 0

    def add_apple(self, apple):
        print('Add apple:', apple)
        self.apple = apple

    def add_water(self, water):
        self.water = water
        print('Add water:', self.water)


if __name__ == '__main__':
    w = apple()
    w.add_apple(99)
    w.add_water(199)
    start_apple()