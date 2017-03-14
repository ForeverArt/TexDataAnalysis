package entity;

import java.util.ArrayList;

public class Content{
	private ArrayList<Receipt> input;
	private ArrayList<Receipt> output;
	public Content(ArrayList<Receipt> input,ArrayList<Receipt> output){
		this.setInput(input);
		this.setOutput(output);
	}
	public ArrayList<Receipt> getInput() {
		return input;
	}
	public void setInput(ArrayList<Receipt> input) {
		this.input = input;
	}
	public ArrayList<Receipt> getOutput() {
		return output;
	}
	public void setOutput(ArrayList<Receipt> output) {
		this.output = output;
	}
	
}
