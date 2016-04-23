package components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cpu
{

	  private static Memory       mem;
	  private static RegisterFile reg;
	  private static final String INSTRUCTIONS_FILE = "src\\Instructions.text";
	  
	public static void initialize()
	{
		Memory mem = Memory.getInstance();
		mem.setInstructionMemory(loadInstructions());
	    reg = RegisterFile.getInstance();
	}
	
	private static ArrayList<Integer> loadInstructions()
	  {

	    ArrayList<Integer> instructions = new ArrayList<Integer>();
	    try (BufferedReader br = new BufferedReader(new FileReader(INSTRUCTIONS_FILE)))
	    {
	      String line;
	      while ((line = br.readLine()) != null)
	      {
	        instructions.add(Integer.parseInt(line, 2));
	      }
	    } catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    return instructions;
	  }
}
