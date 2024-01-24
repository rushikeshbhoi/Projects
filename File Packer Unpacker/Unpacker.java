import java.util.*;
import java.io.*;

class Unpacker
{
    public static void main(String arg[]) throws Exception
    {
        byte Header[] = new byte[100];
        int iFileSize = 0;
        String str = null;
        int iRet = 0, iCnt = 0;

        System.out.println("------------------------------------------------");
        System.out.println("---------- Rushi's Packer Unpacker ----------");
        System.out.println("------------------------------------------------");

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the name of packed file that you want to unpack : ");
        String PackedFile = sobj.nextLine();

        File fobj = new File(PackedFile);
        FileInputStream fiobj = new FileInputStream(fobj);

        while((iRet = fiobj.read(Header, 0, 100)) > 0)
        {
            String Hstr = new String(Header);

            str = Hstr.trim();
            String Tokens[] = str.split(" ");

            File NewFile = new File(Tokens[0]);
            NewFile.createNewFile();

            iFileSize = Integer.parseInt(Tokens[1]);

            byte Buffer[] = new byte[iFileSize];
            fiobj.read(Buffer, 0, iFileSize);

            FileOutputStream foobj = new FileOutputStream(NewFile);
            foobj.write(Buffer, 0, iFileSize);

            System.out.println(Tokens[0]+ " unpacked succesfully");
            iCnt++;
        }

        System.out.println("Unpacking activity completed..");
        System.out.println("Total file unpacked succesfully : "+iCnt);

        System.out.println("------------------------------------------------");
        System.out.println("Thank you for using Rushi's Packer Unpacker");
        System.out.println("------------------------------------------------");
    }
}