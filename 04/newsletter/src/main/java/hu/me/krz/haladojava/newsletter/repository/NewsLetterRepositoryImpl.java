package hu.me.krz.haladojava.newsletter.repository;

import org.springframework.stereotype.Repository;

@Repository
public class NewsLetterRepositoryImpl implements NewsLetterRepository {

	@Override
	public String getNewsLetterText() {
		// TODO Auto-generated method stub
		return "Imagine this is the text of an actual newsletter.";
	}

}
