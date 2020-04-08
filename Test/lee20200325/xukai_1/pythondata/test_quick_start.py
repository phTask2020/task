def reverse(string):
    return string[::-1]


def test_reverse():
    string = "hello world"
    assert reverse(string) == "dlrow olleh"

    another_string = "good"
    assert reverse(another_string) == "doog"

def func(i):
    return i + 2

def test_func():
    assert func(6) == 8

def testone(self):
    x = 'hello'
    assert x == 'hi'