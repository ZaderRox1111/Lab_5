package package_5;

public class InvestmentCalculator
   {

      //The overall purpose of this program is to compute compound interest and doubling interval of an investment
      
      //Create constants, variables, and instantiations
      //Display title
      //Receive input from the user to get investment, rate of return, and time
      //Do necessary calculations
      //Display the results
      //End program
      
      //Create constants
      // Table characters
      private static final char THIN_LINE = '-';
      private static final char THICK_LINE = '=';
      private static final char PIPE = '|';
      private static final String PIPE_SPACE = "| ";
      private static final String SPACE_PIPE = " |";
      
      // Table values
      private static final int TWO_ENDLINES = 2;
      private static final int TABLE_WIDTH = 60;
      private static final int TITLE_WIDTH = 25;
      private static final int LEFT_COLUMN_WIDTH = 40;
      private static final int RIGHT_COLUMN_WIDTH = 17;
      
      // Precision
      private static final int PRECISION = 3;
      
      //Values
      private static final int NUM_COMPOUNDS_PER_YEAR = 1;
      private static final int RULE_OF_72_FACTOR = 72;
      
      // Instantiating the conIO class
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args)
         {
            // TODO Auto-generated method stub
            
            //Declare variables
            double principle, rate, total, doublingPeriod;
            int years;
            
            //Dispaly title
             //Method: printString, printChars, printEndline
            conIO.printString("INVESTMENT CALCULATOR");
            conIO.printEndline();
            conIO.printChars(TITLE_WIDTH, THICK_LINE);
            conIO.printEndlines(TWO_ENDLINES);
            
            //Get input on investment, rate of return, and time
             //Method: promptForDouble, promptForInt
            principle = conIO.promptForDouble("Enter the original investment: ");
            rate = conIO.promptForDouble("Enter the rate of return in %: ");
            years = conIO.promptForInt("Enter the number of years: ");
            
            conIO.printEndline();
            
            //Do the necessary calculations to determine interest and doubling period
             //Method: computeTotal, computeDoublingPeriod
            total = computeTotal(principle, rate, years, NUM_COMPOUNDS_PER_YEAR);
            doublingPeriod = computeDoublingPeriod(rate);
            
            //Display the table containing the results
             //Method: displayResult
            displayResult(principle, total, doublingPeriod);
            
            //End main
             //Method: printString
            conIO.printString("End Program");
            
         }
      
      public static double computeTotal(double principle, double rate, int years, int numberCompoundsPerYear) 
         {
            //Calculate the total compounded interest plus the initial investment
            //Formula: A = P(1 + r/n)^(nt)
            //Split into three easy parts
            double finalAmount, exponent, raisedEquation, rateDecimal;
            
            rateDecimal = rate / 100;
            exponent = numberCompoundsPerYear * years;
            raisedEquation = 1 + rateDecimal / numberCompoundsPerYear;
            finalAmount = principle * Math.pow(raisedEquation, exponent);
            
            return finalAmount;
         }

      public static double computeDoublingPeriod(double rate) 
         {
            //Calculate the time it will take the investment to double
            //formula: time = 72 / interest rate
            double doublingTime;
            
            doublingTime = RULE_OF_72_FACTOR / rate;
            
            return doublingTime;
         }
      
      public static void displayResult(double principle, double total, double doublingPeriod) 
         {
            //Will display the table containing the results
             //Method: printString, printChars, printChar, printEndline
            conIO.printChar(PIPE);
            conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            conIO.printString(PIPE_SPACE);
            conIO.printString("Principle", LEFT_COLUMN_WIDTH -2, "LEFT");
            conIO.printString(SPACE_PIPE);
            conIO.printDouble(principle, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            conIO.printChar(PIPE);
            conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            conIO.printString(PIPE_SPACE);
            conIO.printString("Principle + Compounded Interest", LEFT_COLUMN_WIDTH -2, "LEFT");
            conIO.printString(SPACE_PIPE);
            conIO.printDouble(total, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            conIO.printChar(PIPE);
            conIO.printChars(LEFT_COLUMN_WIDTH, THIN_LINE);
            conIO.printChar(PIPE);
            conIO.printChars(RIGHT_COLUMN_WIDTH, THIN_LINE);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            conIO.printString(PIPE_SPACE);
            conIO.printString("Approximate Doubling Period", LEFT_COLUMN_WIDTH -2, "LEFT");
            conIO.printString(SPACE_PIPE);
            conIO.printDouble(doublingPeriod, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            conIO.printChar(PIPE);
            conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
            conIO.printChar(PIPE);
            conIO.printEndlines(TWO_ENDLINES);
            
         }
      
   }
