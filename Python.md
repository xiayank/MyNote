# Python
### Variables and Types
- You do not need to declare variables before using them, or declare their type. Every variable in Python is an object. 不需要int x= 0, 这些int, string这些数据类型declare
- Strings
Strings are defined either with a `single quote` or a `double quotes`.
`mystring = "Don't worry about apostrophes"`
using double quotes makes it easy to include apostrophes

### Basic Operators
-  modulo (%) operator, which returns the integer remainder of the division. dividend % divisor = remainder.
-  Using two multiplication symbols makes a power relationship.
squared = 7 ** 2
cubed = 2 ** 3
- Python also supports multiplying strings to form a string with a repeating sequence:
lotsofhellos = "hello" * 10 
hellohellohellohellohellohellohellohellohellohello
- Using Operators with Lists
even_numbers = [2,4,6,8]
odd_numbers = [1,3,5,7]
all_numbers = odd_numbers + even_numbers
- Python uses C-style string formatting to `create new, formatted strings`. The "%" operator is used to format a set of variables enclosed in a "tuple" (a fixed size list), together with a format string, which contains normal text together with "argument specifiers", special symbols like "%s" and "%d".
name = "John"
age = 23
print("%d is %s years old." % (name, age))

Here are some basic argument specifiers you should know:

%s - String (or any object with a string representation, like numbers)

%d - Integers

%f - Floating point numbers

%.<number of digits>f - Floating point numbers with a fixed amount of digits to the right of the dot.

%x/%X - Integers in hex representation (lowercase/uppercase)

### Basic String Operations
- len(astring)
  astring = "Hello world!"
- astring.index("o") - this method only recognizes the first.
- astring.count("l")
- astring[3:7]
- astring[3:7:1] astring[3:7: a], a是要skip的数，a= -1 就是reverse lsit []
- astring.upper() 
- astring.lower()
- astring.startswith("Hello") return true or false
- astring.split(" ") return list [] ['Hello', 'world!']

### Conditions

```
if <statement >:
    <do something="">

elif <another statement="" "" true="">: 
    <do something="" else="">
else:
    <do another="" thing="">
```
- `and` `or` 
- The `in` operator
```
name = "John"
if name in ["John", "Rick"]:
	  print("Your name is either John or Rick.")
```
- The `is` operator
和==差不多，但是is是判断是否是instances themselves，==是match the values of the variables
### Loops
用in 来，像java里的
- For loop
```
primes = [2, 3, 5, 7]
for prime in primes:
    print(prime)
```
```
# Prints out the numbers 0,1,2,3,4
for x in range(5):
    print(x)

# Prints out 3,4,5
for x in range(3, 6):
    print(x)
```
- While loop
```
count = 0
while count < 5:
    print(count)
    count += 1 
```
> Notice: for和while都有`:`在每个条件后面

### Functions
block keyword "def"
```
def my_function():
    print("Hello From My Function!")
```
有`:`在function name后面

### Classes and Objects
```
class MyClass:
    variable = "blah"
    def function(self):
        print("This is a message inside the class.")
        
myobjectx = MyClass()//create a new object要带()
myobjectx.function()
```

### Dictionaries
A dictionary is a data type similar to arrays, but works with `keys` and `values` instead of indexes. Each value stored in a dictionary can be `accessed using a key`, which is any type of object (a string, a number, a list, etc.) instead of using its index to address it.
```
phonebook = {}
phonebook["John"] = 938477566
phonebook["Jack"] = 938377264
phonebook["Jill"] = 947662781
```
```
phonebook = {
    "John" : 938477566,
    "Jack" : 938377264,
    "Jill" : 947662781
}

for name, number in phonebook.items():
    print("Phone number of %s is %d" % (name, number))
```
```
del phonebook["John"] delete a item in dictionary
```

### List Comprehensions
List Comprehensions is a very powerful tool, which creates a new list based on another list, in a single, readable line.
```
numbers = [34.6, -203.4, 44.9, 68.3, -12.2, 44.6, 12.7]
newlist = [int(x) for x in numbers if x > 0]
```
等价于
```
for num in numbers:
      if num > 0:
          newlist.append(int(num))
```
### Lambda, filter, reduce and map
#### Lambda
The lambda operator or lambda function is a way to create small anonymous functions, i.e. functions without a name. These functions are throw-away functions 
Lambda functions are mainly used in combination with the functions filter(), map() and reduce(). 
> lambad是用来定义function的，但是不写function
```
lambda 参数:具体的计算
>>> f = lambda x, y : x + y
>>> f(1,1)
2
```
#### map
`r = map(func, seq)`
map() applies the function func to all the elements of the sequence seq. It returns a new list with the elements changed by func
> 将每个在seq里的值都iterate一遍，返回计算后的
```
>>> a = [1,2,3,4]
>>> b = [17,12,11,10]
>>> map(lambda x,y:x+y, a,b)
[18, 14, 14, 14]
```

#### Filtering
The function filter(function, list) offers an elegant way to filter out all the elements of a list, for which the function function returns `True``. 
>只返回list里面，计算后，为true的值
```
>>> fib = [0,1,1,2,3,5,8,13,21,34,55]
>>> result = filter(lambda x: x % 2, fib)
>>> print result
[1, 1, 3, 5, 13, 21, 55]
```
#### Reducing
The function reduce(func, seq) continually applies the function func() to the sequence seq. It returns a single value. 
> [ s1, s2, s3, ... , sn ]，先计算s1,s2结果为r1,再用r1和s3计算。
> [ func(func(s1, s2),s3), ... , sn ]
```
>>> f = lambda a,b: a if (a > b) else b
>>> reduce(f, [47,11,42,102,13])
102
>>> 
```

### 单词

- single quote
- double quotes
- apostrophes  一撇
- parentheses 圆括号
- curly brace 大括号
- Indentation
