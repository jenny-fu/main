package attendance;

public class Student {
	private String firstName;
	private String lastName;
	private boolean present;
	
	public Student(String first, String last) {
		firstName = first;
		lastName = last;
	}
	//returns true if the student has been marked present, false otherwise
		public boolean isPresent() {
			if(present)
				return true;
			else
				return false;
		}

		//sets whether the student has been marked present
		public void setPresent(boolean present) {
			this.present = present;
		}

		//returns the firstName
		public String getFirstName() {
			return firstName;
		}

		//returns the lastNameName
		public String getLastName() {
			return lastName;
		}

		//returns true if 'first' and 'last' match this Attendee's firstName and lastName. This should NOT be case sensitive. 
		public boolean mathces(String first, String last) {
			if(lastName.toLowerCase().equals(last)) {
				if(firstName.toLowerCase().equals(first))
					return true;
				else
					return false;
			}
			else
				return false;
		}

		
		//returns true if 'last' matches this Attendee's lastName. This should NOT be case sensitive.
		public boolean matches(String last) {
			if(lastName.toLowerCase().equals(last))
				return true;
			else
				return false;
			
		}

		//returns three words separated by 20 spaces: 
		//at index 0, the last name
		//at index 20, the first name
		//at index 40, the word PRESENT or ABSENT
		//ADDED CHALLENGE:
		//if last name or first name is longer than 20 characters, 
		//cut off the last three letters and replace with "..."
		public String getReportString() {
			String s1 = lastName;
			if(lastName.length() > 20)
				s1 = s1.substring(0, 17) + "...";
			while(s1.length() < 20) {
				s1 += " ";
			}
			s1 += firstName;
			if(firstName.length() > 20)
				s1 += s1.substring(20, 37) + "...";
			while(s1.length() < 40) {
				s1 += " ";
			}
			if(isPresent())
				s1 += "PRESENT";
			else
				s1 += "ABSENT";
			return s1;
		}
}
