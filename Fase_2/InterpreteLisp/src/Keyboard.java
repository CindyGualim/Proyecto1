/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos 
 * @author Diana Díaz 21066
 * @author Cindy Gualim 21226
 * @author Andres Chivalan 21534
 * @version 1.0 22/03/2022
 */

 //imports
import java.io.*;
import java.util.*;

//es la clase que maneja las entradas del teclado
public class Keyboard

{
   
   /**
    * Manejo de errores
    */

   private static boolean printErrors = true;

   /**
    * contador
    */
   private static int errorCount = 0;

   /**
    * contador de errores 
    * @return errorcount
    */

   public static int getErrorCount()

   {

      return errorCount;

   }
   
   /**
    *  reset a 0 
    * @param count
    */

   public static void resetErrorCount(int count)

   {

      errorCount = 0;

   }

   /**
    * Imprimir los errores
    * @return errores
    */
   public static boolean getPrintErrors()

   {

      return printErrors;

   }

   /**
    *  el set para imprimir los errores
    * @param flag
    */
   public static void setPrintErrors(boolean flag)

   {

      printErrors = flag;

   }

   /**
    * errores
    * @param str
    */
   private static void error(String str)

   {

      errorCount++;

      if (printErrors)

         System.out.println(str);

   }

   /**
    * 
    */
   private static String current_token = null;

   private static StringTokenizer reader;

   private static BufferedReader in = new BufferedReader

   (new InputStreamReader(System.in));

   /**
    * 
    * @return token si hay 
    */
   private static String getNextToken()

   {

      return getNextToken(true);

   }

   /**
    * 
    * @param skip
    * @return token
    */
   private static String getNextToken(boolean skip)

   {

      String token;

      if (current_token == null)

         token = getNextInputToken(skip);

      else

      {

         token = current_token;

         current_token = null;

      }

      return token;

   }

   /**
    * saber cual es el siguiente token
    * @param skip
    * @return token
    */
   private static String getNextInputToken(boolean skip)

   {

      final String delimiters = " \t\n\r\f";

      String token = null;

      try

      {

         if (reader == null)

            reader = new StringTokenizer

            (in.readLine(), delimiters, true);

         while (token == null ||

               ((delimiters.indexOf(token) >= 0) && skip))

         {

            while (!reader.hasMoreTokens()) //mientras sigan existiendo tokens

               reader = new StringTokenizer //se lee el token

               (in.readLine(), delimiters, true);

            token = reader.nextToken();

         }

      }
  
      catch (Exception exception) //manejo de errores

      {

         token = null;

      }

      return token;

   }

   /**
    * cuando se llega al final de la linea
    * @return si hay mas tokens 
    */
   public static boolean endOfLine()

   {

      return !reader.hasMoreTokens();

   }


   /**
    * leer el string
    * @return el string
    */
   public static String readString()

   {

      String str;

      try

      {

         str = getNextToken(false);

         while (!endOfLine()) //mientras no sea el fin de la linea

         {

            str = str + getNextToken(false);

         }

      }

      catch (Exception exception) //manejo de errores

      {

         error("Error reading String data, null value returned.");

         str = null;

      }

      return str;

   }

   /**
    * leer palabras
    * @return token
    */
   public static String readWord()

   {

      String token;

      try

      {

         token = getNextToken();

      }

      catch (Exception exception)

      {

         error("Error reading String data, null value returned.");

         token = null;

      }

      return token;

   }

   /**
    * 
    * @return true/false
    */
   public static boolean readBoolean()

   {

      String token = getNextToken();

      boolean bool;

      try

      {

         if (token.toLowerCase().equals("true"))

            bool = true;

         else if (token.toLowerCase().equals("false"))

            bool = false;

         else

         {

            error("Error reading boolean data, false value returned.");

            bool = false;

         }

      }

      catch (Exception exception) //manejo de errores

      {

         error("Error reading boolean data, false value returned.");

         bool = false;

      }

      return bool;

   }

   /**
    * leer chars 
    * @return valor 
    */
   public static char readChar()

   {

      String token = getNextToken(false);

      char value;

      try

      {

         if (token.length() > 1)

         {

            current_token = token.substring(1, token.length());

         } else

            current_token = null;

         value = token.charAt(0);

      }
 
      catch (Exception exception) //manejo de errores

      {

         error("Error reading char data, MIN_VALUE value returned.");

         value = Character.MIN_VALUE;

      }

      return value;

   }

   /**
    * se lee los números
    * @return valor 
    */
   public static int readInt()

   {

      String token = getNextToken();

      int value;

      try

      {

         value = Integer.parseInt(token);

      }

      catch (Exception exception)

      {

         error("Error reading int data, MIN_VALUE value returned.");

         value = Integer.MIN_VALUE;

      }

      return value;

   }

   /**
    *  se lee si el tipo es long
    * @return valor 
    */
   public static long readLong()

   {

      String token = getNextToken();

      long value;

      try

      {

         value = Long.parseLong(token);

      }

      catch (Exception exception)

      {

         error("Error reading long data, MIN_VALUE value returned.");

         value = Long.MIN_VALUE;

      }

      return value;

   }

   /**
    * si el tipo es float
    * @return valor 
    */
   public static float readFloat()

   {

      String token = getNextToken();

      float value;

      try

      {

         value = (new Float(token)).floatValue();

      }

      catch (Exception exception)

      {

         error("Error reading float data, NaN value returned.");

         value = Float.NaN;

      }

      return value;

   }

   /**
    * se lee si el tipo es double
    * @return valor
    */
   public static double readDouble()

   {

      String token = getNextToken();

      double value;

      try

      {

         value = (new Double(token)).doubleValue();

      }

      catch (Exception exception)

      {

         error("Error reading double data, NaN value returned.");

         value = Double.NaN;

      }

      return value;

   }

}