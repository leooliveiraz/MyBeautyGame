using System;
using System.Net;
using System.Net.Sockets;
using System.Text;

using System.Threading;

using UnityEngine;

public class UdpClientGame : MonoBehaviour
{
  private static UdpClient client;
  private static string hostIp = "127.0.0.1"; //"172.26.125.41"
  private static int hostPort = 1234;
  
  private static Thread threadReceive;
  public static void ConnectToServer()
  {
    client = new UdpClient();
    try
    {
      client.Connect(hostIp,hostPort);
      threadReceive = new Thread(receiveMsg);
      threadReceive.Start();
    }
    catch (Exception e)
    {
      Debug.Log(e.Message);
    }
  }

  void sendMsg(string msg){
    byte [] sendBytes = Encoding.UTF8.GetBytes(msg);
    client.Send(sendBytes, sendBytes.Length);
  }
  static void receiveMsg(){
    while(true){
      IPEndPoint remoteEndPoint = new IPEndPoint(IPAddress.Any,0);
      byte[] receivedBytes = client.Receive(ref remoteEndPoint);
      string msg = Encoding.UTF8.GetString(receivedBytes);
      // ListCommands.addRec(msg);
    }
  }

  
}
