package training.bai10;

public class Paragraph {
	private String paragraph;

	public Paragraph() {
		super();
	}

	public Paragraph(String paragraph) {
		super();
		this.paragraph = paragraph;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	@Override
	public String toString() {
		return "Paragraph [paragraph=" + paragraph + "]";
	}
	
	public int countWord() {
		String[] words = paragraph.trim().split("\\s+");
		return words.length;
	}
	public int countNumberOfCharacter(char c) {
		int count = 0;
		int length = paragraph.length();
		c = convertCharToUpperCase(c);
		for(int i = 0; i< length;i++) {
			char temp = convertCharToUpperCase(paragraph.charAt(i));
			if(temp == c) {
				count++;
			}
		}
		return count;
		
	}
	private char convertCharToUpperCase(char c) {
		return (c >= 97 && c <= 122) ? (char)(c - 32) : c;
	}
	public String formatString() {
		return paragraph.trim().replaceAll("\\s+", " ");
	}
}
