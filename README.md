Names Arguments are a feature that many languages lack. Some call it [Feature Envy.](https://www.fluentcpp.com/2018/12/14/named-arguments-cpp/)

# The Problem
You have a ```menu()``` method that prints out a 5 option menu and gets user input; ```max=5```, ```min=1```. You *also* have a ```budget()``` method that gets a dollar value; ```min=0```.

You want to make an ```input(String prompt, int min, int max)``` class, but sometimes you want min, sometimes you want max, and sometimes you want both.

Additionally, what if you don't want a prompt, but you still want min and max?

*There isn't any clean, easy, non-repetitive way to write this...*

**... until now!**

**Introducing, Named Parameters!**

# Explanation
Think HTML attributes. Ex: ```<img src="bird.jpg" alt="photo of bird">```.

Variables 'src' and 'alt' both correspond to their respective values, regardless of the order they were passed in.

This class lets you do the exact same thing by passing variables into methods based off name, not position.

# Usage
coming soon
