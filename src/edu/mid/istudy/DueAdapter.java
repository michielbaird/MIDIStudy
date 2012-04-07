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

public class DueAdapter extends ArrayAdapter<Announcement> {
	private  Announcement [] announcements;
	private Activity context;
	
	public DueAdapter(Activity context,Announcement [] announcements) {
		super(context, R.layout.announcement ,announcements);
		this.announcements =  announcements;
		this.context = context;
		
	}
	
	static class AnnounceTag {
		TextView textDate;
		TextView textDesc;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Announcement  announcement = announcements[position];
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView;

		rowView = inflater.inflate(R.layout.due_date, null);
		AnnounceTag tag = new AnnounceTag();
		tag.textDate = (TextView)rowView.findViewById(R.id.textDate);
		tag.textDesc = (TextView)rowView.findViewById(R.id.textDesc);
		
		tag.textDate.setText(announcement.announcement);
		tag.textDesc.setText(announcement.course);
		

		rowView.setTag(tag);
		
		return rowView;

	}
}
