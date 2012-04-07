package edu.mid.istudy;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class IStudyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView schedule =  (ListView)findViewById(R.id.listSchedule);
        ListView handin =  (ListView)findViewById(R.id.listHandin);
        Lecture [] lectures =  new Lecture[9];
		lectures[0] = new Lecture(0, 1, "", "");
		lectures[1] = new Lecture(1,8, "MAM1000W", "PD Hanh - LT 1");
		lectures[2] = new Lecture(1,9, "MAM1043H","Mathematics - M302");
		lectures[3] = new Lecture(1,10,"PHY1004W", "RW JAMES - LT 2");
		lectures[4] = new Lecture(1,11, "CSC1015F", "Computer Science - LT2");
		lectures[5] = new Lecture(1,14, "PHY1004W" ,"RW James - Course 1 Lab");
		lectures[6] = new Lecture(0,2,"","" );
		lectures[7] = new Lecture(1,8, "MAM1000W", "PD Hanh - LT 1");
		lectures[8] = new Lecture(1,9, "MAM1043H","Mathematics - M302");
        schedule.setAdapter(new ScheduleAdapter(this,lectures));
        schedule.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent startLogin = new Intent(IStudyActivity.this, CourseActivity.class);				
				startActivity(startLogin);
			}
        	
		});
        Announcement [] announcements = new Announcement[4];
        announcements[0] = new Announcement("PHY1004W", "Lab Report Due(17 April)");
        announcements[1] = new Announcement("CSC1015F", "Assignment 7 Due(18 April)");
        announcements[2] = new Announcement("MAM1043H",  "Test topics");
        announcements[3] = new Announcement("MAM1000W", "Math Talk - Monday 23 April");
        handin.setAdapter(new AnnounceAdapter(this, announcements));
        
    }
}