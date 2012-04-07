package edu.mid.istudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CourseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course);
		ListView announce = (ListView)findViewById(R.id.listAnnounce);
		ListView due = (ListView)findViewById(R.id.listDue);
		ListView notes = (ListView)findViewById(R.id.listNotes);
		
        Announcement [] announcements = new Announcement[2];
        announcements[0] = new Announcement("April 20 - 17h00", "Assignment 7");
        announcements[1] = new Announcement("April 26 - 17h00", "Assignment 8");
        due.setAdapter(new DueAdapter(this, announcements));
        Announcement2 [] announcements2 = new Announcement2[2];
        announcements2[0] =  new Announcement2(0,"sdfjksdfjk");
        announcements2[1] =  new Announcement2(0,"sdfjksdfjk");
        announce.setAdapter(new Announce2Adapter(this,announcements2));
       
        notes.setAdapter(new Announce2Adapter(this,announcements2));
        
	}
}
