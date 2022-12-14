import random
from colorama import Fore


def QuizSim(args):
    total_items = len(args)
    score = 0
    que_n_ans = args
    number = 0
    print(f"Items :{score}/{total_items} passing score is {int(total_items * 0.70)}")
    while que_n_ans:  # the loop runs until the dictionary is empty
        randque = random.choice(list(
            que_n_ans.keys()))  # converts all they key values into list and  choose a random key question based on the user-inputs
        number += 1
        answers = que_n_ans.get(randque)  # get the value of the key from randque
        question = input(f"{number}. {randque}").lower()
        if question == answers.lower():  # checks if the user inputs from question is match to the key value pair from the chosen element
            score += 1
            print(Fore.GREEN+"Correct"+Fore.RESET)
        else:
            print(Fore.RED + f"Correct answer: {Fore.YELLOW}{answers}" + Fore.RESET)


        que_n_ans.pop(
            randque)  # if the question is picked in randque this statement removes that from the list of dictionary to avoid repeating it

    return print(f"Score: {score}/{total_items}!")


