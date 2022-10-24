# Use EnumSet instead of bit fields

EnumSet implements Set interface, but internally it is represented as a bit vector. If the underlying enum type has 64 or fewer elements - and most do - the entire EnumSet is represented with a single long, 
so its performance is comparable to that of a bit field. Bulk operations, such as removeAll, retainAl are implemented using bitwise arithmetic. 