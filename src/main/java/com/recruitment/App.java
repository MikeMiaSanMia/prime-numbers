package com.recruitment;

import com.recruitment.view.MainAppService;

/**
 * @author Michał Bodzek
 *
 */
public class App
{
    public static void main( String[] args ) {
        MainAppService mainAppService = new MainAppService();
        mainAppService.run();
    }
}
