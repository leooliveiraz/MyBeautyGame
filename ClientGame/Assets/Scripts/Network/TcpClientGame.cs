using System.Collections;
using System.Collections.Generic;
using WebSocketSharp;
using UnityEngine;

public class TcpClientGame
{
  public static TcpClientGame Instance { get; private set; }
  public static WebSocket ws;

  public static void ConnectToServer()
  {
    if (!isConnected())
    {
      Debug.Log("Trying to TCP connect");
      ws = new WebSocket("ws://localhost:8080/socket");
      ws.OnMessage += (sender, e) =>
      {
        Debug.Log("Message Received from " + ((WebSocket)sender).Url + ", Data : " + e.Data);
      };
      ws.OnOpen += (sender, e) => {
        Debug.Log("Connected on TCP Server");
      };
      ws.OnError += (sender, e) => {
        Debug.Log("Occured an error on TCP Server");
      };
      ws.OnClose += (sender, e) => {
        Debug.Log("Connection with TCP Server has closed");
      };
      ws.Connect();
    }
  }
  public static bool isConnected()
  {
    return ws != null ? ws.IsAlive : false;
  }



}
