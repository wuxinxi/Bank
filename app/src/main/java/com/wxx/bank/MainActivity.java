package com.wxx.bank;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Socket mSocket;
    private BufferedWriter writer;
    private BufferedReader reader;

    private static final String TAG = "MainActivity";

    private ScheduledExecutorService service;
    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        handler = new MyHandler(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "发起", Toast.LENGTH_SHORT).show();
        service = new ScheduledThreadPoolExecutor(1);

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = "6022000000000200202004c030c1981131000000410602100006376228482941096991511d491212077093600000010499622848" +
                            "2941096991511d156156000000000000000000000011414144912dd000000000000d000000000000d092347000000000323934323239303138393836313830353" +
                            "93833303232390000313536c8e14e9c5b92918d1000000000000000000801000000317fe662045b4d48";
                    byte[] bytes = Tools.hexStringToByte(data);

                    mSocket = new Socket("7.8.0.50", 8807);
                    writer = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream()));
                    reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                    writer.write(data + "\n");
                    writer.flush();

                    String result;
                    while ((result = reader.readLine()) != null) {
                        Log.d(TAG, "收到信息:" + result);
                    }
//                    InputStream ips = mSocket.getInputStream();
//                    byte[] rebyte = Util.readStream(ips);
//                    String remess = new String(rebyte);
                    Log.d(TAG, "收到信息:" + result);
                    Message message = Message.obtain();
                    message.what = 0;
                    message.obj = result;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
                    Message message = Message.obtain();
                    message.what = 1;
                    message.obj = "异常——" + e.getMessage();
                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                    Message message = Message.obtain();
                    message.what = 1;
                    message.obj = "异常——" + e.getMessage();
                    handler.sendMessage(message);
                }
//                finally {
//                    try {
//                        reader.close();
//                        writer.close();
//                        mSocket.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
            }
        });

    }

    static class MyHandler extends Handler {
        private WeakReference<MainActivity> weak;

        public MyHandler(MainActivity activity) {
            weak = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity activity = weak.get();
            if (activity != null) {
                if (msg.obj == null)
                    Toast.makeText(activity, "无数据返回", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity, msg.obj.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getOfPackge() {
        StringBuffer sb = new StringBuffer();
        sb.append(Util.str2cbcd("6002880000"));//TUDU
        sb.append(Util.str2cbcd("603100310005"));//报文头 后四位自定义防止冲突
        sb.append("0200");//请求消息
        sb.append("603C06C13AD09E00");//查询余额位图信息
        sb.append("6217994280000321844");//从磁卡或者IC中读取到的数据，磁卡从2 3磁道堆取数据
        sb.append("310000");//交易处理码
        sb.append("000001");//受卡方系统跟踪号 6位数字 从1至999999循环使用
        sb.append(Util.str2cbcd(Util.getTime_6()));//受卡方所在地时间 6位 hhmmss
        sb.append(Util.str2cbcd(Util.getTime_4()));//受卡方所在地日期 4位 MMDD
        sb.append(Util.str2cbcd(Util.getTime()));//卡有效期 4位 YYMM
        sb.append(Util.str2cbcd("000"));//服务点输入方式码
        sb.append(Util.str2cbcd("00"));//卡片序列号
        sb.append(Util.str2cbcd("00"));//服务点条件码
        sb.append(Util.str2cbcd("06"));//服务点 PIN 获取码
        sb.append("");//受理方标识码
        sb.append("");//2 磁道数据
        sb.append("");//3 磁道数据
        sb.append(Util.buidRandom(12));//检索参考号,12位的流水号
        sb.append("00");//应答码
        sb.append((Util.buildRandomStr(8)));//受卡机终端标识码
        sb.append(Util.buildRandomStr(15));//受卡方标识码
        sb.append("");//附加响应数据
        sb.append("156");//交易货币代码
        sb.append("");//个人标识码数据,个人密码的密文，8字节的2进制
        sb.append("");//安全控制信息
        sb.append("");//附加金额
        sb.append("");//IC 卡数据域
        sb.append("");//应用密文
        sb.append("");//应用信息数据
        sb.append("");//发卡行应用数据
        sb.append("");//不可预知数
        sb.append("");//应用交易计数器
        sb.append("");//终端验证结果
        sb.append("");//交易日期
        sb.append("");//交易类型
        sb.append("");//授权金额a
        sb.append("");//交易货币代码b
        sb.append("");//应用交互特征
        sb.append("");//终端国家代码
        sb.append("");//其它金额c
        sb.append("");//终端性能
        sb.append("");//持卡人验证结果
        sb.append("");//终端类型
        sb.append("");//接口设备序列号
        sb.append("");//专用文件名称
        sb.append("");//应用版本号
        sb.append("");//交易序列计数器
        sb.append("");//卡产品标识
        sb.append("");//发卡行认证数据
        sb.append("");//发卡行脚本 1
        sb.append("");//发卡行脚本 2
        sb.append("");//芯片序列号
        sb.append("");//过程密钥数据
        sb.append("");//终端读取时间
        sb.append("");//自定义域
        sb.append("");//交易类型码
        sb.append("");//批次号
        sb.append("");//网络管理码
        sb.append("");//终端读取能力
        sb.append("");//基于 PBOC 借/贷记标准的 IC 卡条件代码
        sb.append("");//账户类型
        sb.append("");//自定义域
        sb.append("");//MAC
        Log.d(TAG, "参数：" + sb.toString());
        return sb.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        service.shutdown();
    }
}
