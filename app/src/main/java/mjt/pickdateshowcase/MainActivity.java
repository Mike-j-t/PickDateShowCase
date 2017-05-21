package mjt.pickdateshowcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mjt.pickdate.PickDate;

/**
 * Showcase the PickDate DatePicker i.e. how it could be used in an Activity
 *  The main Activity is a very basic activity that has two buttons OK and DONE
 *
 *  If Ok is clicked then the pickdate method is invoked. It is this method
 *  that prepares and shows the PickDate (dialog). Noting that it sets the
 *  resumestate variable to indicate that PickDate has been invoked. The
 *  onResume method gets the date that has been selected.
 *
 *  If DONE is clicked the main activity finishes.
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final int RESUMESTATE_NORMAL = 0;
    private static final int RESUMESTATE_DATEPICKED = 1;
    int resumestate = 0;

    PickDate mypickdate;
    TextView showdate;
    TextView screenpercentage;
    Date testdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resumestate = RESUMESTATE_NORMAL;
        screenpercentage = (TextView) this.findViewById(R.id.screenpercentage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (resumestate) {
            case    RESUMESTATE_DATEPICKED:
                showdate = (TextView) findViewById(R.id.selected_date);
                showdate.setText(
                        new SimpleDateFormat(
                                "EE d MMMM yyyy").format(
                                        mypickdate.getSelectedDate()));

                break;
            default:
                break;
        }
        resumestate = RESUMESTATE_NORMAL;
    }

    /**************************************************************************
     * OK button clicked
     * @param v     The View that was clicked
     */
    public void pickDate(View v) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            testdate = formatter.parse("14/03/2017");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long dateinmills = testdate.getTime();

        // Initialise/Contruct a Date Picker Object
        mypickdate = new PickDate(this,
                System.currentTimeMillis(),
                55
        );
        //mypickdate = new PickDate(this);

        // Set the title (optional)
        // Alternateives are:
        //      (1) A string with at least 1 character will cause that
        //          string to be displayed as the title.
        //      (2) Empty, or null (eg not calling this) will result in the
        //          title defulting to Pick a Date.
        //mypickdate.setTitle("My Custom Title");     // Set the Date Picker's Title
        mypickdate.setTitleBackgroundColour(0xff0000aa); // Note sets entire background
        //mypickdate.setTitletextColour(0xffff0000); // Doesn't work
        mypickdate.setOuterBackgroundColour(0xff7777ff);
        mypickdate.setInnerBackGroundColour(0xff3333ff);
        //mypickdate.setDateGridHeadingsTextColour(0xffff0000);
        //mypickdate.setNotInMonthCellTextColour(0xffaaaaaa);
        //mypickdate.setInMonthCellTextColour(0xff0000ff);
        //mypickdate.setSelectedCellTextColour(0xff00ff00);
        int selectedcellhighlightcolour = 0xff00ff00;
        //mypickdate.setSelectedcellHightColour(selectedcellhighlightcolour);
        //mypickdate.setCellBorder(0xffff0000,1);
        //mypickdate.showSelectedCellHighlight(false);
        //mypickdate.setDateDisplayTextColour(0x33000000);
        //mypickdate.alterHeightToWidthRatio(0.85f);
        //mypickdate.setSelectedCellBackgroundColour(0xffff0000);
        mypickdate.show(this);              // Invoke the Date Picker
        resumestate = RESUMESTATE_DATEPICKED;
    }
    public void pickDateForScreenPercentage(View v) {
        mypickdate = new PickDate(this,
                System.currentTimeMillis(),
                Integer.parseInt(screenpercentage.getText().toString()));
        mypickdate.setTitle("Pick Date SP");
        mypickdate.show(this);
        resumestate = RESUMESTATE_DATEPICKED;

    }
    public void done(View v) {
        this.finish();
    }
}
