## UNDER CONSTRUCTION


### Personal Notes 


#### Menu bar : </br>
Used menu_drawer inside menu that has list of functionalities i want in my app.When we click on them it will not move to new activity rather it will move to new fragment (part as name suggest :> ) because like whatsapp we have chat , status and calls options but when we slide them , the toolbar remain same as it will not create new activity. </br>

so for each item ( Dashboard , Favourites , Profile , About App ) i have to create fragments and they will also have their own xml files for thier UI  </br>

To know currently which fragment is opened we have diff title of toolbar (Actually action bar) as current fragment name and also make the item checked using ischecked = true </br>

move from Fragment 1 -> Fragment 3 -> Fragement 2 ------ we need backpressed function to move Fragment 3 -> Fragment 1 when back button from Fragment 2 is clicked rather than exiting the app but here i have alter the default function of backpressed and make Dashboard Fragment open when back button is pressed.




#### For Dashboard Fragment :: Set as Default Fragment

It has list of books for which i have used RecyclerView ( Preferred over ListView ) </br>
   Component of Recycler View </br>
   -> LayoutManager : How items are displayed </br>
   -> ViewHolder : View--single for all the list items as each list item has same view and also list items are dynamic size so we cannot predefine its number </br>
   -> Adapter : Binds view with data </br>
   
   Dashboard Fragment file and recycler_dashboard_simgle_row file for UI
   (Too confusing rn)
   
   Divided the list item using addItemDecoration
   
    
   #### Internet Permission
   App but does not ask explicitly for internet permission fromuser but it ask from the device
    
    Updated at 08-04-2021
   
