
// =========================================================================== //
//                                                                             //
// Copyright 2008-2012 Andrew Casey, Jun Li, Jesse Doherty,                    //
//   Maxime Chevalier-Boisvert, Toheed Aslam, Anton Dubrau, Nurudeen Lameed,   //
//   Amina Aslam, Rahul Garg, Soroush Radpour, Olivier Savary Belanger,        //
//   Laurie Hendren, Clark Verbrugge and McGill University.                    //
//                                                                             //
//   Licensed under the Apache License, Version 2.0 (the "License");           //
//   you may not use this file except in compliance with the License.          //
//   You may obtain a copy of the License at                                   //
//                                                                             //
//       http://www.apache.org/licenses/LICENSE-2.0                            //
//                                                                             //
//   Unless required by applicable law or agreed to in writing, software       //
//   distributed under the License is distributed on an "AS IS" BASIS,         //
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  //
//   See the License for the specific language governing permissions and       //
//   limitations under the License.                                            //
//                                                                             //
// =========================================================================== //
 
/* THIS FILE IS AUTO-GENERATED FROM natlab_options.xml. DO NOT MODIFY. */

package natlab.options;
import java.util.*;

/** Natlab command-line options parser.
 */
public class Options extends OptionsBase {
    public Options() { }



    public boolean parse( String[] argv ) {
        for( int i = argv.length; i > 0; i-- ) {
            pushOptions( argv[i-1] );
        }
        while( hasMoreOptions() ) {
            String option = nextOption();
            if( option.charAt(0) != '-' ) {
                files.add( option );
                continue;
            }
            while( option.charAt(0) == '-' ) {
                option = option.substring(1);
            }
            if( false );

            else if( false 
            || option.equals( "h" )
            || option.equals( "help" )
            )
                help = true;
  
            else if( false 
            || option.equals( "pretty" )
            )
                pretty = true;
  
            else if( false 
            || option.equals( "s" )
            || option.equals( "simplify" )
            )
                simplify = true;
  
            else if( false 
            || option.equals( "x" )
            || option.equals( "xml" )
            )
                xml = true;
  
            else if( false 
            || option.equals( "j" )
            || option.equals( "json" )
            )
                json = true;
  
            else if( false 
            || option.equals( "m" )
            || option.equals( "matlab" )
            )
                matlab = true;
  
            else if( false 
            || option.equals( "n" )
            || option.equals( "natlab" )
            )
                natlab = true;
  
            else if( false 
            || option.equals( "quiet" )
            )
                quiet = true;
  
            else if( false
            || option.equals( "outdir" )
            || option.equals( "od" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( od.length() == 0 )
                    od = value;
                else {
                    System.out.println( "Duplicate values "+od+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false 
            || option.equals( "server" )
            )
                server = true;
  
            else if( false
            || option.equals( "sport" )
            || option.equals( "sp" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( sp.length() == 0 )
                    sp = value;
                else {
                    System.out.println( "Duplicate values "+sp+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false 
            || option.equals( "nh" )
            || option.equals( "noheart" )
            )
                noheart = true;
  
            else if( false 
            || option.equals( "v" )
            || option.equals( "version" )
            )
                version = true;
  
            else if( false 
            || option.equals( "mclint" )
            )
                mclint = true;
  
            else if( false 
            || option.equals( "t" )
            || option.equals( "tamer" )
            )
                tamer = true;
  
            else if( false 
            || option.equals( "inline" )
            )
                inline = true;
  
            else if( false
            || option.equals( "args" )
            || option.equals( "arguments" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( arguments.length() == 0 )
                    arguments = value;
                else {
                    System.out.println( "Duplicate values "+arguments+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false 
            || option.equals( "tamerplus" )
            )
                tamerplus = true;
  
            else if( false
            || option.equals( "lpath" )
            || option.equals( "lp" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( lp == null )
                    lp = new LinkedList();

                lp.add( value );
            }
  
            else if( false
            || option.equals( "in" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( in == null )
                    in = new LinkedList();

                in.add( value );
            }
  
            else if( false
            || option.equals( "main" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( main.length() == 0 )
                    main = value;
                else {
                    System.out.println( "Duplicate values "+main+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false 
            || option.equals( "preferences" )
            || option.equals( "pref" )
            )
                pref = true;
  
            else if( false
            || option.equals( "set_matlab_path" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( set_matlab_path == null )
                    set_matlab_path = new LinkedList();

                set_matlab_path.add( value );
            }
  
            else if( false
            || option.equals( "add_matlab_path" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( add_matlab_path == null )
                    add_matlab_path = new LinkedList();

                add_matlab_path.add( value );
            }
  
            else if( false
            || option.equals( "set_natlab_path" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( set_natlab_path == null )
                    set_natlab_path = new LinkedList();

                set_natlab_path.add( value );
            }
  
            else if( false
            || option.equals( "add_natlab_path" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( add_natlab_path == null )
                    add_natlab_path = new LinkedList();

                add_natlab_path.add( value );
            }
  
            else if( false 
            || option.equals( "show_preferences" )
            || option.equals( "show_pref" )
            )
                show_pref = true;
  
            else if( false 
            || option.equals( "mix10c" )
            )
                mix10c = true;
  
            else if( false 
            || option.equals( "use_region_arrays" )
            )
                use_region_arrays = true;
  
            else if( false 
            || option.equals( "no_intok" )
            )
                no_intok = true;
  
            else if( false
            || option.equals( "vec_par_length" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( vec_par_length.length() == 0 )
                    vec_par_length = value;
                else {
                    System.out.println( "Duplicate values "+vec_par_length+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false
            || option.equals( "arg_info" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( arg_info.length() == 0 )
                    arg_info = value;
                else {
                    System.out.println( "Duplicate values "+arg_info+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false
            || option.equals( "class_name" )
            ) {
                if( !hasMoreOptions() ) {
                    System.out.println( "No value given for option -"+option );
                    return false;
                }
                String value = nextOption();
    
                if( class_name.length() == 0 )
                    class_name = value;
                else {
                    System.out.println( "Duplicate values "+class_name+" and "+value+" for option -"+option );
                    return false;
                }
            }
  
            else if( false 
            || option.equals( "codegen" )
            )
                codegen = true;
  
            else if( false 
            || option.equals( "nocheck" )
            )
                nocheck = true;
  
            else {
                System.out.println( "Invalid option -"+option );
                return false;
            }
        }
    
        return true;
    }


    public boolean help() { return help; }
    private boolean help = false;
    public void set_help( boolean setting ) { help = setting; }
  
    public boolean pretty() { return pretty; }
    private boolean pretty = false;
    public void set_pretty( boolean setting ) { pretty = setting; }
  
    public boolean simplify() { return simplify; }
    private boolean simplify = false;
    public void set_simplify( boolean setting ) { simplify = setting; }
  
    public boolean xml() { return xml; }
    private boolean xml = false;
    public void set_xml( boolean setting ) { xml = setting; }
  
    public boolean json() { return json; }
    private boolean json = false;
    public void set_json( boolean setting ) { json = setting; }
  
    public boolean matlab() { return matlab; }
    private boolean matlab = false;
    public void set_matlab( boolean setting ) { matlab = setting; }
  
    public boolean natlab() { return natlab; }
    private boolean natlab = false;
    public void set_natlab( boolean setting ) { natlab = setting; }
  
    public boolean quiet() { return quiet; }
    private boolean quiet = false;
    public void set_quiet( boolean setting ) { quiet = setting; }
  
    public String od() { return od; }
    public void set_od( String setting ) { od = setting; }
    private String od = "";
    public boolean server() { return server; }
    private boolean server = false;
    public void set_server( boolean setting ) { server = setting; }
  
    public String sp() { return sp; }
    public void set_sp( String setting ) { sp = setting; }
    private String sp = "";
    public boolean noheart() { return noheart; }
    private boolean noheart = false;
    public void set_noheart( boolean setting ) { noheart = setting; }
  
    public boolean version() { return version; }
    private boolean version = false;
    public void set_version( boolean setting ) { version = setting; }
  
    public boolean mclint() { return mclint; }
    private boolean mclint = false;
    public void set_mclint( boolean setting ) { mclint = setting; }
  
    public boolean tamer() { return tamer; }
    private boolean tamer = false;
    public void set_tamer( boolean setting ) { tamer = setting; }
  
    public boolean inline() { return inline; }
    private boolean inline = false;
    public void set_inline( boolean setting ) { inline = setting; }
  
    public String arguments() { return arguments; }
    public void set_arguments( String setting ) { arguments = setting; }
    private String arguments = "";
    public boolean tamerplus() { return tamerplus; }
    private boolean tamerplus = false;
    public void set_tamerplus( boolean setting ) { tamerplus = setting; }
  
    public List lp() { 
        if( lp == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return lp;
    }
    public void set_lp( List setting ) { lp = setting; }
    private List lp = null;
    public List in() { 
        if( in == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return in;
    }
    public void set_in( List setting ) { in = setting; }
    private List in = null;
    public String main() { return main; }
    public void set_main( String setting ) { main = setting; }
    private String main = "";
    public boolean pref() { return pref; }
    private boolean pref = false;
    public void set_pref( boolean setting ) { pref = setting; }
  
    public List set_matlab_path() { 
        if( set_matlab_path == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return set_matlab_path;
    }
    public void set_set_matlab_path( List setting ) { set_matlab_path = setting; }
    private List set_matlab_path = null;
    public List add_matlab_path() { 
        if( add_matlab_path == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return add_matlab_path;
    }
    public void set_add_matlab_path( List setting ) { add_matlab_path = setting; }
    private List add_matlab_path = null;
    public List set_natlab_path() { 
        if( set_natlab_path == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return set_natlab_path;
    }
    public void set_set_natlab_path( List setting ) { set_natlab_path = setting; }
    private List set_natlab_path = null;
    public List add_natlab_path() { 
        if( add_natlab_path == null )
            return java.util.Collections.EMPTY_LIST;
        else
            return add_natlab_path;
    }
    public void set_add_natlab_path( List setting ) { add_natlab_path = setting; }
    private List add_natlab_path = null;
    public boolean show_pref() { return show_pref; }
    private boolean show_pref = false;
    public void set_show_pref( boolean setting ) { show_pref = setting; }
  
    public boolean mix10c() { return mix10c; }
    private boolean mix10c = false;
    public void set_mix10c( boolean setting ) { mix10c = setting; }
  
    public boolean use_region_arrays() { return use_region_arrays; }
    private boolean use_region_arrays = false;
    public void set_use_region_arrays( boolean setting ) { use_region_arrays = setting; }
  
    public boolean no_intok() { return no_intok; }
    private boolean no_intok = false;
    public void set_no_intok( boolean setting ) { no_intok = setting; }
  
    public String vec_par_length() { return vec_par_length; }
    public void set_vec_par_length( String setting ) { vec_par_length = setting; }
    private String vec_par_length = "";
    public String arg_info() { return arg_info; }
    public void set_arg_info( String setting ) { arg_info = setting; }
    private String arg_info = "";
    public String class_name() { return class_name; }
    public void set_class_name( String setting ) { class_name = setting; }
    private String class_name = "";
    public boolean codegen() { return codegen; }
    private boolean codegen = false;
    public void set_codegen( boolean setting ) { codegen = setting; }
  
    public boolean nocheck() { return nocheck; }
    private boolean nocheck = false;
    public void set_nocheck( boolean setting ) { nocheck = setting; }
  

    public String getUsage() {
        return ""

+"\nGeneral Options:\n"
      
+padOpt(" -h -help", "Display help and exit" )
+padOpt(" -pretty", "Prettyprint the files" )
+padOpt(" -s -simplify", "Simplify the AST after parsing" )
+padOpt(" -x -xml", "Prints the XML IR" )
+padOpt(" -j -json", "Prints the JSON IR" )
+padOpt(" -m -matlab", "No-op" )
+padOpt(" -n -natlab", "Use Natlab input" )
+padOpt(" -quiet", "Suppress all information messages" )
+padOpt(" -outdir DIR -od DIR", "Output everything to this dir rather than stdout" )
+"\nServer options:\n"
      
+padOpt(" -server", "Run frontend in server mode on a given port, default is 47146" )
+padOpt(" -sport PORT -sp PORT", "Set the port the server runs on" )
+padOpt(" -nh -noheart", "Turns off the need for a heartbeat signal" )
+"\nVersion option:\n"
      
+padOpt(" -v -version", "Get the current version of Natlab" )
+"\nMcLint options:\n"
      
+padOpt(" -mclint", "Run McLint" )
+"\nTamer options:\n"
      
+padOpt(" -t -tamer", "Tame a Matlab program" )
+padOpt(" -inline", "Inline the whole Matlab program in one function, if possible" )
+padOpt(" -args ARG -arguments ARG", "Specifies type of arguments to the main function (default is 'double')" )
+"\nTamer+ option:\n"
      
+padOpt(" -tamerplus", "Get the Tamer+ version of a program" )
+"\npath and file options:\n"
      
+padOpt(" -lpath PATH -lp PATH", "Path of locations to find matlab files" )
+padOpt(" -in FILE(S)", "Files to be used as input" )
+padOpt(" -main ARG", "file taken to be the main file and entry point of the program" )
+"\nSetting Natlab Stored Preferences:\n"
      
+padOpt(" -preferences -pref", "perform preference operation" )
+padOpt(" -set_matlab_path PATH", "Set Path (all path dirs) of a Matlab installation" )
+padOpt(" -add_matlab_path PATH", "adds the given paths to the Matlab installation path" )
+padOpt(" -set_natlab_path PATH", "Set path directories where to find source code and packages" )
+padOpt(" -add_natlab_path PATH", "adds the given paths to the Natlab path" )
+padOpt(" -show_preferences -show_pref", "Display all stored preferences" )
+"\nMiX10 Preferences:\n"
      
+padOpt(" -mix10c", "Compile MATLAB to X10" )
+padOpt(" -use_region_arrays", "Use region arrays" )
+padOpt(" -no_intok", "disable IntegerOkay analysis" )
+padOpt(" -vec_par_length ARG", "Define the threshold vector size to use parallel vector operations" )
+padOpt(" -arg_info ARG", "Provide information about the input argument. " )
+padOpt(" -class_name ARG", "Name of the X10 class file to be generated." )
+"\nMc2For Preferences:\n"
      
+padOpt(" -codegen", "Transform MATLAB to Fortran with run-time ABC code" )
+padOpt(" -nocheck", "Transform MATLAB to Fortran without run-time ABC code" );
    }

}
  