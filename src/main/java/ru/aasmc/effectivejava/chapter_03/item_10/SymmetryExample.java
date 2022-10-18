package ru.aasmc.effectivejava.chapter_03.item_10;

public class SymmetryExample {
    public static final class CaseInsensitiveStringBroken {
        private final String s;
        public CaseInsensitiveStringBroken(String s) {
            this.s = s;
        }
        // Broken - violates symmetry!

        @Override
        public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveStringBroken) {
                return s.equalsIgnoreCase(((CaseInsensitiveStringBroken)o).s);
            }
            if (o instanceof String) { // One-way interoperability!
                return s.equalsIgnoreCase((String) o);
            }
            return false;
        }
    }

    public static final class CaseInsensitiveStringCorrect {
        private final String s;
        public CaseInsensitiveStringCorrect(String s) {
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof CaseInsensitiveStringCorrect) {
                return s.equalsIgnoreCase(((CaseInsensitiveStringCorrect)o).s);
            }
            return false;
        }
    }

}
