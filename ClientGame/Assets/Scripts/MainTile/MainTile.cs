using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using UnityEngine.SceneManagement;
public class MainTile : MonoBehaviour
{
  public void Quit(){
    Application.Quit();
  }

  public void change2CreateAccountTile(){
        SceneManager.LoadScene("AccountCreationTile");
  }
  public void change2LoginTile(){
        SceneManager.LoadScene("LoginTile");
  }

}
