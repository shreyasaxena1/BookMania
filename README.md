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
   
   using http not https (secured http) so we need to add a peice of code extra</br>
   directory xml -> network_security_config.xml </br>
   
   Dashboard Fragment file and recycler_dashboard_simgle_row file for UI
   (Too confusing rn)
   
   Divided the list item using addItemDecoration
   
    
   #### Internet Permission
   App does not ask explicitly for internet permission fromuser but it ask from the device. </br>
   Manifest File
   
   Whether device connected to internet or not </br>
   package - Util : Class Manager </br>
   
   Network Request - GET(Retrieve) and Post(SEND)</br>
   Send request --> Volley , Retrofit ,OkHTTP (Libraries) and HttpURLConnection (Default method)</br>
   Volley -> send Request and response in JSON </br>
   Server -> API -> DB -> API -> Server </br>
   Andriod APP ------> Main Thread : Res. for processes visible to users 
               ------> Workers Thread : Res. for bg processes </br>
            
  Header -  tell type of content being sent and recieve
            , helps to send a unique token with rqt
   
  Using http not https (secured version of http) so we need to add extra peice of code</br>
  Directory xml -> network_security_config.xml </br>
  
    
    Updated at 11-04-2021
   
