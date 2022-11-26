public class LeapYear {
    public boolean leapYear(int year) {
        if (year % 400 == 0)
            return true;

        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;

        // Else If a year is multiple of 4,
        // then it is a leap year
        if (year % 4 == 0)
            return true;
        return false;
    }

    public int isLeapYear(int A) {
        if (A % 400 == 0)
            return 1;

        // Else If a year is multiple of 100,
        // then it is not a leap year
        if (A % 100 == 0)
            return 0;

        // Else If a year is multiple of 4,
        // then it is a leap year
        if (A % 4 == 0)
            return 1;
        return 0;
    }

    public int solve(int A) {
        if (A % 400 == 0 || (A % 4 == 0) || (A % 100 == 1 ))
            return 1;
        
        return 0;
    }

    public static void main(String[] args) {

    }
}
