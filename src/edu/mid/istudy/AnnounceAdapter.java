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

public class AnnounceAdapter extends ArrayAdapter<Announcement> {
	private  Announcement [] announcements;
	private Activity context;
	
	public AnnounceAdapter(Activity context,Announcement [] announcements) {
		super(context, R.layout.announcement ,announcements);
		this.announcements =  announcements;
		this.context = context;
		
	}
	
	static class AnnounceTag {
		TextView textCourse2;
		TextView textDescription;
		ImageView imageCourse2;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Announcement  announcement = announcements[position];
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView;

		rowView = inflater.inflate(R.layout.announcement, null);
		AnnounceTag tag = new AnnounceTag();
		tag.imageCourse2 = (ImageView)rowView.findViewById(R.id.imageCourse2);
		tag.textCourse2 = (TextView)rowView.findViewById(R.id.textCourse2);
		tag.textDescription = (TextView)rowView.findViewById(R.id.textDescription);
		
		tag.textCourse2.setText(announcement.course);
		tag.textDescription.setText(announcement.announcement);
		
		if (announcement.course.equals("MAM1000W")){
			tag.imageCourse2.setImageResource(R.drawable.blue);
		} else if (announcement.course.equals("CSC1015F")){
			tag.imageCourse2.setImageResource(R.drawable.green);
		} else if (announcement.course.equals("MAM1043H")){	
			tag.imageCourse2.setImageResource(R.drawable.red);
		} else if (announcement.course.equals("PHY1004W")){	
			tag.imageCourse2.setImageResource(R.drawable.yellow);
		}
		rowView.setTag(tag);
		
		return rowView;

	}
}
