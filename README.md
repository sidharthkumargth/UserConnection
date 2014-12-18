UserConnection
==============
IMPORT TO ECLIPSE


Open GitHub

Download userconnection.jar from the Google Drive link [https://drive.google.com/file/d/0B7eqSUBgNez0SXBtLVBxNFhKSm8/view?usp=sharing] then paste it in libs folder of your project.

Then go to properties of that project and click on Java Build path then select libraries and click [add jar ] then from libs folder import the userconnection.jar file.



HOW TO USE

First of all i will tell you no need to use AsyncTask for this, it will save your time, code and effort to connect to any web services or url.

UserConnection uc=new UserConnection(int);

uc.startConnection("http://www.test.com/test.php");
the int value depends on the number of parameters you are using for that webservice if no parameters then use 0 

e.g ///for no parameters

UserConnection uc=new UserConnection(0);
uc.startConnection("http://www.google.com");

e.g ///for 2 parameters (for Login )

UserConnection uc=new UserConnection(2);
uc.setupValues("email","test@test.com");
uc.setupValues("password","test");
uc.startConnection("http://www.google.com");

CONNECTION STATUS LISTENER

public class Test extends Activity implements ConnectionStatusListener{
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
UserConnection uc=new UserConnection(2)
uc.setupValues("email","test@test.com");
uc.setupValues("password","test");
uc.setConnectionStatusListener(this);
uc.startConnection("http://www.google.com");
}
@Override
	public void onError(Status arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Status arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProgressUpdate(Status arg0) {
		// TODO Auto-generated method stub
		}

}



USE MULTIPLE USERCONNECTION

public class Test extends Activity implements ConnectionStatusListener{
UserConnection uc1,uc2;
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		///////////////  uc1
		
uc1=new UserConnection(2)
uc1.setupValues("email","test@test.com");
uc1.setupValues("password","test");
uc1.setConnectionStatusListener(this);
uc1.startConnection("http://www.google.com");

////////////////////uc2

uc2=new UserConnection(2)
uc2.setupValues("email","test@test.com");
uc2.setupValues("password","test");
uc2.setConnectionStatusListener(this);
uc2.startConnection("http://www.google.com");
}
@Override
	public void onError(Status arg0) {
		// TODO Auto-generated method stub
		log.d("error",arg0.getErrorMessage());
	}

	@Override
	public void onStart(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Status arg0) {
		// TODO Auto-generated method stub
		if(arg0.arg0.getConnectionHolder()==uc1){
		////for uc1
		Log.d("uc1",arg0.getResponse());// output of webservice
		
		}else if(arg0.arg0.getConnectionHolder()==uc1){
		////for uc2
		Log.d("uc2",arg0.getResponse());
		}
	}

	@Override
	public void onProgressUpdate(Status arg0) {
		// TODO Auto-generated method stub
		int progress=arg0.getProgress()  // progress statis for downloading image
		}

}


DOWNLOADING A FILE FROM URL

public class Test extends Activity implements ConnectionStatusListener{
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
UserConnection uc=new UserConnection(0)
uc.startDownloadfrom("http://www.technotrigger.com/wp-content/uploads/2014/01/house-in-green-field.jpg","/sdcard/downloadedfile1.jpg");

uc.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls.jpg","/sdcard/downloadedfile2.jpg");

uc.startDownloadfrom("http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg","/sdcard/downloadedfile3.jpg");
uc.startDownloadfrom("http://tmacfitness.com/wp-content/uploads/2013/04/Beauty-of-nature-random-4884759-1280-800.jpg","/sdcard/downloadedfile4.jpg");

uc.startDownloadfrom("http://freedwallpaper.com/wp-content/uploads/2014/03/6-autumn-nature-sandbox-images_2053316.jpg","/sdcard/downloadedfile5.jpg");


/////////// It will download all 5 images at a time we can use a for loop and download many images also
}
@Override
	public void onError(Status arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Status arg0) {
		// TODO Auto-generated method stub
		Log.d("file path",arg0.getFilePath());
		
		
		///////////if downloaded file is an image then u can get bitmap of that file directly by
		
		Bitmap b=arg0.getBitmap();
		ImageView.setImageBitmap(b);
		
		///////////////  OR
		
		ImageView.setImageDrawable(Drawable.createFromPath(arg0.getFile()));
	}

	@Override
	public void onProgressUpdate(Status arg0) {
		// TODO Auto-generated method stub
			int progress=arg0.getProgress()
		}

}



DIRECT DOWNLOAD A BITMAP 


public class Test extends Activity implements ConnectionStatusListener{
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
UserConnection uc=new UserConnection(0)
uc.startDownloadfrom("http://www.technotrigger.com/wp-content/uploads/2014/01/house-in-green-field.jpg","/sdcard/downloadedfile1.jpg");

uc.startDownloadImage("http://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls1.jpg");
uc.startDownloadImage("http://upload.wikimedia.org/wikipedia/commons/3/36/Hopetoun_falls2.jpg");



/////////// It will download all g images at a time we can use a for loop and download many images also
}
@Override
	public void onError(Status arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(Status arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Status arg0) {
		// TODO Auto-generated method stub
		
		Bitmap b=arg0.getImageBitmap();
		ImageView.setImageBitmap(b);
		
	}

	@Override
	public void onProgressUpdate(Status arg0) {
		// TODO Auto-generated method stub
		
		}

}



for any other support please mail me at sidharthsahu@icloud.com
for any donation paypal emailid sidharthkumargth@gmail.com
