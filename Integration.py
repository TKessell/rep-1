"""
__author__ = "Domenic Kessell"
 Integration Project 2019
 Uses every concept learned in COP1500 in one program
"""


def fact():
    print(
        "Did you know that if you start with one penny at the start of the "
        "month and double it every day (for thirty days), you will end with "
        "over 5 million dollars! Here is the proof: ")
    x = .01
    for j in range(29):
        x *= 2
        print(x)


def game():
    number = int(input("Enter the sum of the digits in your SSN: "))
    print("Doing some magic...")
    newNumber = int((((2 * number) + 8) / 2) - number)
    print(newNumber, " <- correlate this number to a letter in the alphabet.")
    print("Think of a country that starts with that letter.\n"
          "Now, think of an animal that starts with the last letter of the "
          "country.\n Finally, a color that starts with the last letter of "
          "the animal.")
    print("My guess is... Denmark Kangaroo Orange? Am i right?")
    print()


def ops(one, two):
    print("Subtraction: a-b =", one - two)
    print("Addition: a+b =", one + two)
    print("Multiplication: a*b =", one * two)
    print("Division with no remainder: a//b =", one // two)
    print("Powers: a**b: =", one ** two)
    print("Modulus (remainder) division: a%b =", one % two)
    print()


def av():
    i = int(
        input("To find the average of two numbers, first enter one number: "))
    j = int(input("Then enter a second number: "))
    print(
        "The average is the first number + the second number, all divided by "
        "two: ", (i + j) / 2)
    print()


def main():
    goAgain = True
    choice = True
    name = input("Welcome, what is your name? ")
    print("Hello", name + ". This is my python integration project.")
    while goAgain:
        selection = input(
            "What would you like to do? \n 1. Find an average \n 2. Numeric "
            "operations \n 3. A cool numbers game.\n 4. An interesting fact "
            "about money. ")
        if selection == "1":
            av()
        elif selection == "2":
            i = int(input("Enter a number: "))
            j = int(input("Enter another number: "))
            ops(i, j)
        elif selection == "3":
            game()
        elif selection == "4":
            fact()
        else:
            print("Sorry, that is not a valid selection :( ")
        while choice:
            again = input("Would you like to make another selection?"
                          "(y/n) ")
            if again == "y" or again == "Y":
                goAgain = True
                break
            if again == "n" or again == "N":
                goAgain = False
                choice = False
            else:
                print("That is not a valid choice (y/n)")
    print("All done. Shutting down... -_-")


# function call to main (this runs first)
main()
