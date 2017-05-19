# PickDateShowCase
PickDate Customisable Date Picker ShowCase

*Note this is a first attempt at creating a module*

**PickDateShowCase** is an Android App to showcases the **PickDate** module.

**PickDateShowCase** itself is a very simple basic App with a single Activity showing 2 buttons.

The **PickDate** button invokes the **Pickdate** module.

The **Done** button finishes the activity.

**PickDate** is a class with various methods that culminate in a **Date Picker** dialog being displayed.
The dialog allows the selection of a date which is extracted via the **`getSelectedDate`** method.

In it's most simple form you instantiate a **PickDate** object, use the **`show`** method and then use the  **`getSelectedDate`** 
method to retrieve the date that has been selected.

Here is an example of the most basic Code:-

    PickDate mypickdate = new PickDate(this); //Instantiate (construct) a PickDate Object
    mypickdate.show();  //Show/Invoke the Date Picker
    long retrieveddate = mypickdate.getSelectedDate(); //get thedate that was selected.
    
 In the above example the initial (selected) date will be the current date. Default attributes will be applied. Pickdate appears as :-

![PickDate - default](http://i.imgur.com/07VMsKJ.jpg)

 
 There are two additional constructors :-
 
     Pickdate(Context, InitialDate);
     
     PickDate(Context, InitialDate, ScreenPercentage);
     
 Where:-
 **Context** is the context of the invoking Activity. *(required by all three constructors)*.
 
 **InitialDate** is a long date timestamp *e.g. as could be obtained via `System.getCCurrentTimeMillis()`*. 
 It sets the initial date of the date picker.
 
 **ScreenPercentage** is the percentage, as an int, of the screen that the height of the Dialog will use. The default is 75%. 
 However, this may be automatically adjusted to accomodate a suitable width (landscape).

![PickDate with ScreenPercentage 55](http://i.imgur.com/KhTeM4V.jpg)
 
 In addition to the constructor, there areadditional methods that can alter attributes of the presented PickDate dialog. All of these methods should be used before invoking the **`show()`** method.

## Title ##
The default title is *Pick a Date*. This can be changed using the **`setTitle(title)`**, where title is a string.

e.g. **`mypickdate.setTitle("My Custom Title");`**

The background colour of the title area (*the entire dialog if **`setOuterBackground`** or **`setInnerBackground`** methods aren't used*) can be altered using the **`setTitleBackgroundColour(colour)`**. Where colour is an argb int.

e.g. **`mypickdate.setTitleBackgroundColour(0xff0000aa);`** along with **`mypickdate.setTitle("My Custom Title");`** will result in:-

![Title Text and Title Background set](http://i.imgur.com/HU2QTCa.jpg)

## Outer and Inner Backgrounds

Methods **`setOuterBackgroundColour(colour)`** and **`setInnerBackGroundColour(colour)`** will alter the outer and inner Background colours respectively. The **Outer Background** emcompasses the entire dialog . The **Inner Background** is slightly smaller than the Outer Background, thus catering for a border (if you look at the defaults screenshots above you will notice a border).

Here is an example where the Title Text and Title Background are set as in the previous scren shot and with the Outer and inner Backgrounds set using :-

        mypickdate.setTitle("My Custom Title");
        mypickdate.setTitleBackgroundColour(0xff0000aa); // BLUE
        mypickdate.setOuterBackgroundColour(0xff7777ff); // LIGHT BLUE
        mypickdate.setInnerBackGroundColour(0xff3333ff); // LIGHTISH BLUE

![](http://i.imgur.com/QRgAWwx.jpg)

## The Selected Date Display ##
The currently selected date appears immediately below the title. The colour can be changed using the **`setDateDisplayTextColour(colour)`** method. The following code would set it to black:-

        mypickdate.setDateDisplayTextColour(0xff000000);

## Cells ##
The Calendar like Date grid is comprised of 3 types of cells:- 

Dates that are not in the current month; these appear at the start/top and at the end (these by default are dimmed).

Dates that are in the current month and

The currently Selected Date.
 
 
 
 
 

 
 
 
 
