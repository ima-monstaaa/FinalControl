package edu.redlandscc.finalcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.net.telnet.*;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;




public class AndroidSocket extends Activity implements OnClickListener {
    TextView text;
    Button buttonvc;
    Button button2;
    Button wakebtn;
    /*Button edit4;*/
    String command;
    String command2;
    String wakecmd;
    String username;
    String password;
    String server;
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
        text = (TextView)findViewById(R.id.text);
        buttonvc = (Button)findViewById(R.id.buttonvc);
        button2 = (Button)findViewById(R.id.button2);
        wakebtn = (Button)findViewById(R.id.wakebtn);
       /* edit4 = (Button)findViewById(R.id.buttonvc);// (EditText)findViewById(R.id.edit4);*/
        server = "164.58.136.50";
        username = "admin";
        password = "72243888";
        command = "vcbutton play 2"; /* edit4.getEditableText(); */
        command2 = "vcbutton stop";
        wakecmd = "wake";
        Button wakebtn = (Button)findViewById(R.id.wakebtn);
        wakebtn.setOnClickListener(this);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button buttonvc = (Button)findViewById(R.id.buttonvc);
        buttonvc.setOnClickListener(this);
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

        }}


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

