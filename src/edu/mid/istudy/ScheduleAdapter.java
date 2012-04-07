package edu.mid.istudy;


import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ScheduleAdapter extends ArrayAdapter<Lecture> {
	private  Lecture [] lectures;
	private Activity context;
	
	public ScheduleAdapter(Activity context,Lecture [] lectures) {
		super(context, R.layout.list_item,lectures);
		this.lectures =  lectures;
		this.context = context;
		
	}
	
	static class LectureTag {
		TextView textTime;
		ImageView imageCourse;
		TextView textCourse;
		TextView textVenue;
	}
	static class DayTag {
		TextView textDay;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Lecture  lecture = lectures[position];
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView;
		
		if (lecture.day == 0){
			rowView = inflater.inflate(R.layout.day_item, null);
			DayTag tag = new DayTag();
			tag.textDay = (TextView)rowView.findViewById(R.id.textDay);
			if (lecture.time == 1) {
				tag.textDay.setText("Tuesday - 17 April");
			} else if (lecture.time == 2) {
				tag.textDay.setText("Wednesday - 18 April 2012");
			}
		} else {
			rowView = inflater.inflate(R.layout.list_item, null);
			LectureTag tag = new LectureTag();
			tag.textTime = (TextView)rowView.findViewById(R.id.textTime);
			tag.imageCourse = (ImageView)rowView.findViewById(R.id.imageCourse);
			tag.textCourse = (TextView)rowView.findViewById(R.id.textCourse);
			tag.textVenue = (TextView)rowView.findViewById(R.id.textVenue);
			tag.textTime.setText(lecture.time + "");
			tag.textCourse.setText(lecture.course);
			tag.textVenue.setText(lecture.venue);
			if (lecture.course.equals("MAM1000W")){
				tag.imageCourse.setImageResource(R.drawable.blue);
			} else if (lecture.course.equals("CSC1015F")){
				tag.imageCourse.setImageResource(R.drawable.green);
			} else if (lecture.course.equals("MAM1043H")){	
				tag.imageCourse.setImageResource(R.drawable.red);
			} else if (lecture.course.equals("PHY1004W")){	
				tag.imageCourse.setImageResource(R.drawable.yellow);
			}
			rowView.setTag(tag);
		}
		return rowView;
		
		
	}


}
