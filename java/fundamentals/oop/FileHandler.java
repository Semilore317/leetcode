package fundamentals.oop;

import java.io.*;
import java.util.*;
import javax.swing.*;

// sequential file demo
public class FileHandler {

    public static void main(String[] arguments) {
        try { // try1
            Scanner input = new Scanner(new File("data.dat"));
            int count = 0; // for counting records
            String out = "Results of processing the data \n\n ";
            out += "Rec. No. \tSurname \tOtherNames \tMatric No.\tScore Total\tMean Score\n\n";
            // read all the records
            while (input.hasNext()) {
                count++;
                // Assign all the records’ fields to their identifiers
                String name1 = input.next();
                String name2 = input.next();
                int matric = input.nextInt();
                int score1 = input.nextInt();
                int score2 = input.nextInt();
                double score3 = input.nextDouble();
                //summing data

                double sum = score1 + score2 + score3;
                double average = sum / 3.0; // the mean
                out += count + "\t\t" + name1 + "\t\t" + name2 + "\t\t"
                        + matric + "\t\t" + sum + "\t\t" + average + "\t\t"
                        + "\n";
                // writing to an output file
                try { // try2 to operate output file
                    //Creating the output file
                    File file = new File("OutputFile.txt");
                    PrintWriter output = new PrintWriter(file);
                    output.write(out); // write all the output
                    output.close(); //Close the output file
                }//end try2
                catch (Exception exception) { //catch for try2
                    JOptionPane.showMessageDialog(null, "Cannot write to file!", "Error", JOptionPane.ERROR_MESSAGE);
                }//end catch for try2
            }//end while
        } catch (Exception exception) { //catch for try1
            JOptionPane.showMessageDialog(null, "Cannot read from file!", "Error", JOptionPane.ERROR_MESSAGE);
        }//end catch for try1
        //Notifying the user of the end of processing…
        JOptionPane.showMessageDialog(null, "Data has been written to file!", "Writing Complete",
                JOptionPane.INFORMATION_MESSAGE);
    } // end method main( )
} //end class seqData