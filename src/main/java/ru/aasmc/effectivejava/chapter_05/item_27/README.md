# Eliminate unchecked warnings

Advice: Eliminate every unchecked warning that you can.
If you can't eliminate a warning, but you can prove that the code that provoked the warning is typesafe, then (and only then) suppress the warning with an @SuppressWarnings("unchecked") annotation used on the smallest scope possible. Add a comment every time you use @SuppressWarnings("unchecked"). 