# Java Calculator using Postfix

A simple **Java calculator** that evaluates arithmetic expressions using **postfix notation**.  
This project accepts **infix expressions** (the usual way we write math, e.g., `X + Y`), converts them into **postfix notation** (e.g., `X Y +`), and then calculates the result using a **stack-based approach**.

---

## Features
- Accepts standard arithmetic expressions in **infix notation**  
- Converts infix expressions to **postfix notation**  
- Evaluates postfix expressions using **stack operations** (`push` and `pop`)  
- Supports basic operators: `+`, `-`, `*`, `/`, and parentheses `()`  
- Provides step-by-step computation using a **stack data structure**

---

## Example

**Infix Expression:**  
(5 + 3) * 2 - 4 / 2


**Converted to Postfix:**  
5 3 + 2 * 4 2 / -


**Result:**  

---

![Java Postfix Calculator](https://github.com/LeFLEUR-ui/java-calculator/blob/main/output.webp?raw=true)

---

##  How It Works

1. **Input:** The user enters an arithmetic expression in **infix notation**.  
2. **Conversion:** The expression is converted into **postfix notation** using the **Shunting Yard algorithm**.  
3. **Evaluation:**  
   - Numbers are **pushed** onto the stack.  
   - When an operator is encountered, operands are **popped** from the stack, the operation is performed, and the result is **pushed** back.  
4. **Output:** The final result is displayed to the user.


