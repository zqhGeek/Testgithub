package com.zhy.imageloader;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PicActivity extends Activity {
	private GridView gridview;
	private List<String> stringArrayListExtra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forum_activity_creatforum);
		stringArrayListExtra = (List<String>) getIntent().getSerializableExtra(
				"mSelectedImage");
		gridview = (GridView) findViewById(R.id.forum_edit_gv_noScrollgridview);
		gridview.setAdapter(new GridAdapter(this));
	}

	public class GridAdapter extends BaseAdapter {
		private LayoutInflater inflater; // 视图容器

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return stringArrayListExtra.size();
		}

		public GridAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {

				convertView = inflater.inflate(
						R.layout.forum_item_published_grida, parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_grida_image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.image.setImageBitmap(BitmapFactory
					.decodeFile(stringArrayListExtra.get(position)));
			return convertView;

		}

		public class ViewHolder {
			public ImageView image;
		}
	}
}
