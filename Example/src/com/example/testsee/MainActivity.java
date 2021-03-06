package com.example.testsee;


import in.amigoapps.lolipopdialog.CustomDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import net.amigoapps.usetoconnect.ConnectionStatusListener;
import net.amigoapps.usetoconnect.DownloadedFile;
import net.amigoapps.usetoconnect.HTTP;
import net.amigoapps.usetoconnect.Status;
import net.amigoapps.usetoconnect.UserConnection;
import net.amigoapps.usetoconnect.UserConnection.MultiPartConnection;
import net.amigoapps.usetoconnect.UserException;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements ConnectionStatusListener{
	UserConnection uc,uc1;
	ImageView iv;
	TextView tv;
	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setSubtitle("Only for test");
		See s=new See(this);
		s.setNavigationDrawer(true);
		iv=(ImageView)findViewById(R.id.imageView1);
		tv=(TextView)findViewById(R.id.ttt);
		pb=(ProgressBar)findViewById(R.id.progressBar1);
		 uc=new UserConnection(2);
		uc.setHTTPMethod(HTTP.POST);/// for GET  uc.setHTTPMethod(HTTP.GET);
		
		/* OR 
		 * uc.setHTTPMethod("POST");/// for GET  uc.setHTTPMethod("GET");
		 * 
		 */
		
		uc.setupValues("email", "sidharthsahu@gmail.com");
		uc.setupValues("password", "test");
		
		uc.setConnectionStatusListener(this);
		uc.startConnection("http://taskbell.com/tb/login.php");
		//uc.startDownloadfrom("http://www.kingsoftstore.com/images/presentation-templates/report-ppt-template-059.dpt","/sdcard/downloadedfile.jpg");
		//uc.startDownloadImage("http://i00.i.aliimg.com/wsphoto/v0/1157302568/2013-girls-new-style-popular-purple-sexy-lingeries-LC1105-free-shipping.jpg");
		//uc.startDownloadfrom("http://www.technotrigger.com/wp-content/uploads/2014/01/house-in-green-field.jpg","/sdcard/downloadedfile1.jpg");
		//uc.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls.jpg","/sdcard/downloadedfile2.jpg");
		//uc.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg","/sdcard/downloadedfile3.jpg");
		//uc.startDownloadfrom("http://tmacfitness.com/wp-content/uploads/2013/04/Beauty-of-nature-random-4884759-1280-800.jpg","/sdcard/downloadedfile4.jpg");
		//uc.startDownloadfrom("http://freedwallpaper.com/wp-content/uploads/2014/03/6-autumn-nature-sandbox-images_2053316.jpg","/sdcard/downloadedfile5.jpg");
		//uc.startDownloadImage("http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg");
		//uc.startMultipartConnection("http://www.google.co.in");
		uc1=new UserConnection(0);
	UserConnection.MultiPartConnection k=new UserConnection.MultiPartConnection(9);
			//uc1.setHTTPMethod("GET");
			//"/sdcard/downloadedfile.jpg"
			uc1.setConnectionStatusListener(this);
			uc1.startDownloadImage("http://i00.i.aliimg.com/wsphoto/v0/1157302568/2013-girls-new-style-popular-purple-sexy-lingeries-LC1105-free-shipping.jpg");
			
			uc1.startDownloadfrom("http://www.technotrigger.com/wp-content/uploads/2014/01/house-in-green-field.jpg","/sdcard/downloadedfile1.jpg");
			uc1.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls.jpg","/sdcard/downloadedfile2.jpg");
			uc1.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg","/sdcard/downloadedfile3.jpg");
			
			//uc.
			//uc1.startConnection("http://www.facebook.com");
	}
	//Toast.makeText(getApplicationContext(), message, 1).show();

	@Override
	public void onError(Status arg0) {
		// TODO Auto-generated method stub
		
		try {
			Toast.makeText(getApplicationContext(), "error"+arg0.getErrorMessage(), 1).show();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(Status arg0) {
		if(arg0.getConnectionHolder()==uc){
		//Toast.makeText(getApplicationContext(), "uc"+arg0.getMessage(), 1).show();
		}else if(arg0.getConnectionHolder()==uc1){
			//Toast.makeText(getApplicationContext(), "uc1"+arg0.getMessage(), 1).show();
			}
	}

	@Override
	public void onStop(Status arg0) {
		// TODO Auto-generated method stub
		if(arg0.getConnectionHolder()==uc){
         
		//Log.d(arg0.getConnectionHolder().toString(), arg0.getResponse()+"");
		try {
			
			//	iv.setImageBitmap(arg0.getImageBitmap());
			
			Toast.makeText(getApplicationContext(), arg0.getConnectionHolder()+"++"+arg0.getResponse()+" "+HTTP.GET+" "+HTTP.POST, Toast.LENGTH_LONG).show();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				iv.setImageBitmap(arg0.getImageBitmap());
			} catch (UserException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				try {
					iv.setImageBitmap(arg0.getFile().getBitmap());
				} catch (UserException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
	

	@Override
	public void onProgressUpdate(Status arg0) {
		// TODO Auto-generated method stub
		try {
			tv.setText("Progress "+arg0.getProgress());
			pb.setProgress(arg0.getProgress());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		 if(id==android.R.id.home){
			Toast.makeText(this, "click", 1).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
