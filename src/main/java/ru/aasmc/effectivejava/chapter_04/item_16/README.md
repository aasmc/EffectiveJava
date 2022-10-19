# In public classes use accessor methods, not public fields

If a class is accessible outside its package, provide accessor methods. If a class is package-private or is a private nested 
class, there's nothing inherently wrong with exposing its data fields. 