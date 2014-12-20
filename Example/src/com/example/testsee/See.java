package com.example.testsee;



import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;

public class See {
	Activity ctx;
	public See(Activity ctx){
	this.ctx=ctx;
}
	public void setNavigationDrawer(boolean b){
		if(b){
			ctx.getActionBar().setDisplayHomeAsUpEnabled(true);
		}else{
			ctx.getActionBar().setDisplayHomeAsUpEnabled(false);
		}
	}
	
	
}
