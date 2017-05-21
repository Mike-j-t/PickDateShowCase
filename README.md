# PickDateShowCase
PickDate Customisable Date Picker ShowCase

*Note this is a first attempt at creating a module*

**PickDateShowCase** is an Android App to showcases the **PickDate** module.

**PickDateShowCase** itself is a very simple basic App with a single Activity showing 3 buttons.

The first **Pick Date** button invokes the **PickDate** module.

The second **Pick Date** button invokes the **PickDate** module with the supplied (editable) screen percentage.

The **Done** button finishes the activity.

**PickDate** is a class with various methods that culminate in a **Date Picker** dialog being displayed.
The dialog allows the selection of a date which is extracted via the **`getSelectedDate`** method (*in the PickdateShowCase activity this is used in the activity's `onResume()` method*). The **PickDate** date picker is intended to be large and simple to cater for those, such as senior citizens, who may not want snazziness for the sake of ease of use.

In it's most simple form you instantiate a **PickDate** object, use the **`show`** method and then use the  **`getSelectedDate`** method to retrieve the date that has been selected.

Here is an example of the most basic Code (note that getSelectedDate would not work as the activity would be resumed):-

    PickDate mypickdate = new PickDate(this); //Instantiate (construct) a PickDate Object
    mypickdate.show();  //Show/Invoke the Date Picker
    long retrieveddate = mypickdate.getSelectedDate(); //get thedate that was selected.
    
 In the above example the initial (selected) date will be the current date. Default attributes will be applied. Pickdate appears as :-

![PickDate defult](http://i.imgur.com/1Eo046h.jpg)

By default the initial date is the current date. Note many aspects can be changed quite simply. However, selection of the date (clicking a date to select a date, adjusting the month and/or year via the 4 buttons and completion via the OK button) remain unchanged.

 
 There are two additional constructors :-
 
     Pickdate(Context, InitialDate);
     
     PickDate(Context, InitialDate, ScreenPercentage);
     
 Where:-
 **Context** is the context of the invoking Activity. *(required by all three constructors)*.
 
 **InitialDate** is a long date timestamp *e.g. as could be obtained via `System.getCCurrentTimeMillis()`*. 
 It sets the initial date of the date picker.
 
 **ScreenPercentage** is the percentage, as an int, of the screen that the height of the Dialog will use. The default is 75%. However, this may be automatically adjusted to accomodate a suitable width.

In the following example 55 has been used as the **screen percentage** :-

![Screen Percentage at 55](http://i.imgur.com/A9jniYN.jpg)

This example uses is as above but in LandScape :-

![Screen Percentage 55 LandScape](http://i.imgur.com/JPD66tM.jpg)
 
 In addition to the constructor, there areadditional methods that can alter attributes of the presented PickDate dialog. All of these methods should be used before invoking the **`show()`** method.

## Title ##
The default title is *Pick a Date*. This can be changed using the **`setTitle(title)`**, where title is a string.

e.g. **`mypickdate.setTitle("My Custom Title");`**

The background colour of the title area (*the entire dialog if **`setOuterBackground`** or **`setInnerBackground`** methods aren't used*) can be altered using the **`setTitleBackgroundColour(colour)`**. Where colour is an argb int.

e.g. **`mypickdate.setTitleBackgroundColour(0xff0000aa);`** along with **`mypickdate.setTitle("My Custom Title");`** will result in:-

![Title and TitleBackGroundColour changed](http://i.imgur.com/9MpdNgJ.jpg)

## Outer and Inner Backgrounds

Methods **`setOuterBackgroundColour(colour)`** and **`setInnerBackGroundColour(colour)`** will alter the outer and inner Background colours respectively. The **Outer Background** emcompasses the entire dialog . The **Inner Background** is slightly smaller than the Outer Background, thus catering for a border (if you look at the defaults screenshots above you will notice a border).

Here is an example where the Title Text and Title Background are set as in the previous scren shot and with the Outer and inner Backgrounds set using :-

        mypickdate.setTitle("My Custom Title");
        mypickdate.setTitleBackgroundColour(0xff0000aa); // BLUE
        mypickdate.setOuterBackgroundColour(0xff7777ff); // LIGHT BLUE
        mypickdate.setInnerBackGroundColour(0xff3333ff); // LIGHTISH BLUE

![Outer and Inner Backgrounds Applied](http://i.imgur.com/tR0B5YO.jpg)

## The Selected Date Display ##
The currently selected date appears immediately below the title. The colour can be changed using the **`setDateDisplayTextColour(colour)`** method. The following code would set it to black:-

        mypickdate.setDateDisplayTextColour(0xff000000);

![DateDisplayTextColour changed](http://i.imgur.com/V8K6hab.jpg)

## Cells ##
The Calendar like Date grid is comprised of 3 types of cells:- 

1. Dates that are not in the current month; these appear at the start/top and at the end (these by default are dimmed).
1. Dates that are in the current month and
1. The currently Selected Date.

Above the Date cells (DateGrid) are **headings** for each column which equate to the respective day of the week (Mon, Tue ...).

The text colour of the column headings can be changed using the **`setDateGridHeadingsTextColour(colour)`** method e.g.
    
        mypickdate.setDateGridHeadingsTextColour(0xffff0000) // RED

![DateGrid Column Headings](http://i.imgur.com/cGbmkF5.jpg)

The text colour of each type of cell can be changed with **`setNotInMonthCellTextColour(colour)`**, **`setInMonthCellTextColour(colour)`** and **`setSelectedCellTextColour(colour)`** for cell types 1,2 and 3 respectively.

e.g.

        mypickdate.setNotInMonthCellTextColour(0xffffff00);  // YELLOW
        mypickdate.setInMonthCellTextColour(0xffffffff);     // WHITE
        mypickdate.setSelectedCellTextColour(0xff00ff00);    // GREEN


![All 3 types of Date Text Cell Colours](http://i.imgur.com/Gr2ejIq.jpg)

The colour of the selected cell's hightlight can be changed using **`selectedcellhighlightcolour(colour)`**

e.g. 

        mypickdate.setSelectedcellHightColour(0xffffff00);  // YELLOW again

![HighLight changed](http://i.imgur.com/WwZlfz3.jpg)

The Highlight can also be disabled using **`showSelectedCellHighlight(false);`** or enabled (it is by default) using **`mypickdate.showSelectedCellHighlight(true);`**.

The background of the selected cell can also be changed using **`setSelectedCellBackgroundColour(colour)`**.

e.g.
        mypickdate.setSelectedCellBackgroundColour(0xffff0000); // YELLOW

with the highlight still on :-

![Selected Cell BackGround changed highlight on](http://i.imgur.com/q3QHY1g.jpg)

or with


        mypickdate.showSelectedCellHighlight(false);
        mypickdate.setSelectedCellBackgroundColour(0xffff0000); // YELLOW

![Selected Cell BackGround changed Highlight off](http://i.imgur.com/oOPo5fO.jpg)
