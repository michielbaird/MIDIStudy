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

public class Announce2Adapter extends ArrayAdapter<Announcement2> {
	private  Announcement2 [] announcements;
	private Activity context;
	
	public Announce2Adapter(Activity context,Announcement2 [] announcements) {
		super(context, R.layout.announcement ,announcements);
		this.announcements =  announcements;
		this.context = context;
		
	}
	
	static class AnnounceTag {
		TextView textAnn;
		ImageView imageLogo;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Announcement2  announcement = announcements[position];
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView;

		rowView = inflater.inflate(R.layout.proper_announce, null);
		AnnounceTag tag = new AnnounceTag();
		tag.textAnn = (TextView)rowView.findViewById(R.id.textLOL);
		tag.imageLogo = (ImageView)rowView.findViewById(R.id.imageLogo);
		
		tag.textAnn.setText(announcement.announcement);
		//tag.text.setText(announcement.course);
		

		rowView.setTag(tag);
		
		return rowView;

	}
}
