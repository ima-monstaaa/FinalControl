package edu.redlandscc.finalcontrol;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.apache.commons.net.telnet.*;
import org.apache.commons.net.telnet.TelnetClient;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;




public class AndroidSocket extends Activity implements OnClickListener {

    TextView text;
    ButtonRectangle buttonvc;
    ButtonRectangle button2;
    ButtonRectangle wakebtn;
    ButtonRectangle endbtn;
    ImageView email;
    FloatingActionButton action_a;
    FloatingActionButton action_b;
    FloatingActionButton action_c;
    /*Button edit4;*/
    String command;
    String command2;
    String wakecmd;
    String username;
    String password;
    String server;
    String mute;
    String volumeup;
    String volumedn;
    String endcall;
    private String USER = null;
    private String PASS = null;
    private String CMD = null;
    private String host = null;
    private int port = 24;
    private TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;
    StringBuffer sb;
    Handler mHandler = new Handler();
    int len;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_socket);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        action_a = (FloatingActionButton)findViewById(R.id.action_a);
        action_b = (FloatingActionButton)findViewById(R.id.action_b);
        action_c = (FloatingActionButton)findViewById(R.id.action_c);
        text = (TextView)findViewById(R.id.text);
        buttonvc = (ButtonRectangle)findViewById(R.id.buttonvc);
        button2 = (ButtonRectangle)findViewById(R.id.button2);
        wakebtn = (ButtonRectangle)findViewById(R.id.wakebtn);
        endbtn = (ButtonRectangle)findViewById(R.id.endbtn);
        email = (ImageView)findViewById(R.id.email);
       /* edit4 = (Button)findViewById(R.id.buttonvc);// (EditText)findViewById(R.id.edit4);*/
        server = "164.58.136.50";
        username = "admin";
        password = "72243888";
        command = "vcbutton play 2"; /* edit4.getEditableText(); */
        command2 = "vcbutton stop";
        wakecmd = "wake";
        mute = "mute near toggle";
        volumeup = "volume up";
        volumedn = "volume down";
        endcall = "hangup video";
        FloatingActionButton action_a = (FloatingActionButton)findViewById(R.id.action_a);
        action_a.setOnClickListener(this);
        FloatingActionButton action_b = (FloatingActionButton)findViewById(R.id.action_b);
        action_b.setOnClickListener(this);
        FloatingActionButton action_c = (FloatingActionButton)findViewById(R.id.action_c);
        action_c.setOnClickListener(this);
        ImageView email = (ImageView)findViewById(R.id.email);
        email.setOnClickListener(this);
        ButtonRectangle wakebtn = (ButtonRectangle)findViewById(R.id.wakebtn);
        wakebtn.setOnClickListener(this);
        ButtonRectangle button2 = (ButtonRectangle)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        ButtonRectangle buttonvc = (ButtonRectangle)findViewById(R.id.buttonvc);
        buttonvc.setOnClickListener(this);
        ButtonRectangle endbtn = (ButtonRectangle)findViewById(R.id.endbtn);
        endbtn.setOnClickListener(this);
        text.setText("Android Socket" + "\n");
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
        /*Button1 switch starts here*/
            case R.id.buttonvc:


    // TODO Auto-generated method stub
            text.setText("Android Socket" + "\n");
            try {
                telnet.connect(server, 24);
                in = telnet.getInputStream();
                out = new PrintStream(telnet.getOutputStream());
                telnet.setKeepAlive(true);
                Thread mThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
    // TODO Auto-generated method stub
                        try {
                            sb = new StringBuffer();
                            while (true)
                            {
                                len = in.read();
                                String s = Character.toString((char)len);
                                sb.append( s );
                                AndroidSocket.this.mHandler.post(new Runnable(){
                                    @Override
                                    public void run() {
    // TODO Auto-generated method stub
                                        AndroidSocket.this.text.getText();
                                        AndroidSocket.this.text.append( sb.toString() );
                                    }
                                });
                                System.out.println( sb );
                                mylogin();
                                mypass();
                                mycommand();
                            }
                        } catch (IOException e) {
    // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
                mThread.start();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        break;
            /*Button2 switch begins here*/
            case R.id.button2:
                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    mycommand2();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
        break;

            case R.id.wakebtn:


                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    mywake();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case R.id.endbtn:

                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    endcall();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case R.id.email:

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "michael.cartwright@redlandscc.edu", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Need help room #");
                startActivity(Intent.createChooser(emailIntent, "Request Assistance..."));

            case R.id.action_c:

                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    mutecommand();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case R.id.action_b:

                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    volumedn();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case R.id.action_a:

                // TODO Auto-generated method stub
                text.setText("Android Socket" + "\n");
                try {
                    telnet.connect(server, 24);
                    in = telnet.getInputStream();
                    out = new PrintStream(telnet.getOutputStream());
                    telnet.setKeepAlive(true);
                    Thread mThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                sb = new StringBuffer();
                                while (true)
                                {
                                    len = in.read();
                                    String s = Character.toString((char)len);
                                    sb.append( s );
                                    AndroidSocket.this.mHandler.post(new Runnable(){
                                        @Override
                                        public void run() {
                                            // TODO Auto-generated method stub
                                            AndroidSocket.this.text.getText();
                                            AndroidSocket.this.text.append( sb.toString() );
                                        }
                                    });
                                    System.out.println( sb );
                                    mylogin();
                                    mypass();
                                    volumeup();
                                }
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });
                    mThread.start();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                break;

        }}


    private void endcall() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(endcall + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(endcall + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void volumedn() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(volumedn + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(volumedn + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void volumeup() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(volumeup + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(volumeup + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void mutecommand() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(mute + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(mute + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void mycommand2() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(command2 + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(command2 + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void mycommand() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(command + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(command + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }

    private void mywake() throws IOException {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("SNMP Enabled:        True")) {
            out.println(wakecmd + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        } else
        if (sb.toString().endsWith("# ")) {
            out.println(wakecmd + "\r\n");
            out.flush();
            out.println("exit\r\n");
            out.flush();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            disconnect();
        }
    }


    private void mypass() {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("Password: ")) {
            out.println(password + "\r\n");
            out.flush();
        } else
        if (sb.toString().endsWith("password: ")) {
            out.println(password + "\r\n");
            out.flush();
        }
    }
    private void mylogin() {
// TODO Auto-generated method stub
        if (sb.toString().endsWith("login: ")) {
            out.println(username + "\r\n");
            out.flush();
        }
    }
    public void disconnect() {
        try {
            in.close();
            out.close();
            telnet.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

