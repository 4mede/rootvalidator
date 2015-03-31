package eu.thedarken.rootvalidator.tools;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

import eu.thedarken.rootvalidator.R;

/**
 * Created by darken on 22.02.2015.
 */
public class ShareHelper {

    public static void share(Activity activity, String subject, ArrayList<String> out) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        StringBuilder _printOut = new StringBuilder();
        for (String s : out)
            _printOut.append(s + "\n");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, _printOut.toString());
        try {
            activity.startActivity(Intent.createChooser(sharingIntent, activity.getResources().getString(R.string.share)));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(activity, "No app available to share results.", Toast.LENGTH_SHORT).show();
        }
    }
}
